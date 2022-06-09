package org.kosta.myproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.mapper.MemberMapper;
import org.kosta.myproject.vo.MemberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	private final MemberMapper memberMapper;
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	public MemberController(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}
	
	@GetMapping("findMemberById")
	public String findMemberById(String id, Model model) { //query string
		
		MemberVO mvo = memberMapper.findMemberById(id);
		
		if(mvo == null)
			return "member/findbyid-fail";
		else {
			model.addAttribute("mvo", mvo);
			return "member/findbyid-ok";
		}
	}
	
	@GetMapping("findMemberListByAddress")
	public String findMemberListByAddress(String address, Model model) {
		
		List<MemberVO> memberList = memberMapper.findMemberListByAddress(address);
		model.addAttribute("memberList", memberList);
		return "member/findbyaddress-result.html";
	}
	
	@RequestMapping("session-test")
	public String sessionTest(HttpServletRequest request) {
		//jsp에서는 session 기본 생성, thymeleaf는 생성하지 않는다.
		HttpSession session = request.getSession(false);
		// 세션이 존재하면 기존 세션 반환, 없으면 null 반환
		logger.debug("session test: {}", session);
		return "home";
	}
	
	@RequestMapping("session-test2")
	public String sesstionTest2(HttpSession session) {
		//매개변수로 session 전달시, 세션이 없으면 생성
		logger.debug("session test2: {}",session);
		return "home";
	}
	
	@PostMapping("login")
	//memberVO 전달
	public String login(MemberVO memberVO, HttpServletRequest request, Model model) {
		//System.out.println(memberVO);
		MemberVO mvo = memberMapper.login(memberVO);
		System.out.println(mvo);
		//redirect
		if(mvo != null) {
			//최초 session을 만들어주어야 null pointer exception 발생하지 않는다.
			HttpSession session = request.getSession();
			session.setAttribute("mvo", mvo);
			//home redirect
			//return "redirect:home";
			return "redirect:/";
		}else
			return "member/login-fail";
	}
	
	@PostMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null)
			session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("updateMemberForm")
	public String updateMemberForm() {
		return "member/update-form";
	}
	
	@PostMapping("updateMember")
	public String updateMember(MemberVO memberVO, HttpServletRequest request) {
		memberMapper.updateMember(memberVO); //업데이트
		MemberVO mvo = memberMapper.findMemberById(memberVO.getId()); //해당 정보로 세션정보 수정(form 제출 정보)
		HttpSession session = request.getSession(false); //id는 변하지 않는 유일값이므로 기준값으로 설정
		
		if(session == null || session.getAttribute("mvo")==null) {
			return "redirect:home";
		}else {
			session.setAttribute("mvo", mvo);
			return "redirect:updateResult";
		}
	}
	
	@RequestMapping("updateResult")
	public String updateResult() {
		return "member/update-result";
	}
	
	@GetMapping("registerMemberForm")
	public String registerMemberForm() {
		return "member/register-form";
	}
	
	@PostMapping("registerMember")
	public String registerMember(MemberVO memberVO) {
		memberMapper.registerMember(memberVO);
		return "redirect:registerMemberResult";
	}
	
	@RequestMapping("registerMemberResult")
	public String registerMemberResult() {
		return "member/register-result";
	}
}
