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
}
