package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.CustomerVO;
import org.kosta.myproject.model.MemberVO;
import org.kosta.myproject.model.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyTestController {
	@RequestMapping("hello.do")
	public ModelAndView MyTest() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result1"); //viewResolver 설정에 의해 WEB-INF/views/result1.jsp로 응답
		mv.addObject("info1", "맛점");
		return mv;
	}
	
	@RequestMapping("hi.do")
	public String hi(Model model) {
		//return string 정보 = view name
		model.addAttribute("info1", "점심메뉴");
		return "result2";
	}
	
	@RequestMapping("paramTest1.do")
	//RequestParam 생략 가능
	public String paramTest1(@RequestParam String customerId, int money, Model model, HttpServletRequest request) {
		System.out.println(customerId);
		model.addAttribute("customerInfo",customerId+"와 "+money);
		request.setAttribute("customerInfo2", "테스트!");
		return "result3";
	}
	
	@RequestMapping("paramTest2.do")
	public String paramTest2(String memberName, String memberAddress) {
		System.out.println(memberName+", "+memberAddress);
		return "result4";
	}
	
	@RequestMapping("paramTest3.do")
	public String paramTest4(String[] hobby) {
		for(int i=0;i<hobby.length;i++) {
			System.out.println(hobby[i]);
		}
		return "result5";
	}
	
	@PostMapping("methodTest1.do")
	public String methodTest1() {
		//post 방식에 대해서만 처리
		return "result5";
	}
	
	@RequestMapping(method= RequestMethod.POST, value="methodTest2.do")
	public String methodTest2(String content) {
		System.out.println(content);
		return "result5";
	}
	
	@PostMapping("pramTest4.do")
	public String paramTest4(CustomerVO customerVO){
		System.out.println(customerVO);
		//자동으로 VO 생성, view에서도 forward되어 사용 가능
		return "result5";
	}
	
	@PostMapping("pramTest5.do")
	public String paramTest4(UserVO userVO){
		System.out.println(userVO);
		//자동으로 VO 생성, view에서도 forward되어 사용 가능
		return "result5";
	}
	
	@PostMapping("redirectTest.do")
	public String redirectTest(CustomerVO cvo) {
		//현재 모든 요청은 Front인 DispatcherServlet으로 일괄 최초 처리됨
		//redirect를 진행하기 위해선 컨트롤러 메서드를 별도로 만들어야 함
		return "redirect:registerResult.do?id="+cvo.getId();
	}
	
	@RequestMapping("registerResult.do")
	public String registerResult(String id, Model model) {
		System.out.println("redirect!");
		System.out.println(id+"를 받아왔습니다.");
		return "result6";
	}
	
	@PostMapping("login.do")
	public String login(String id, String password, MemberVO mvo, HttpSession session) {
		System.out.println(id+" "+password);
		session.setAttribute("mvo", mvo);
		return "redirect:loginResult.do";
	}
	
	@RequestMapping("loginResult.do")
	public String loginResult() {
		return "result7";
	}
}
