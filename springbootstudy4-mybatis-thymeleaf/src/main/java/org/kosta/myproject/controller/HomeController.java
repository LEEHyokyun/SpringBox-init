package org.kosta.myproject.controller;

import javax.servlet.http.HttpSession;

import org.kosta.myproject.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("message","hello spring boot!");
		model.addAttribute("imageName", "thymeleaf.png");
		return "index";
	}
	
	@RequestMapping("study1")
	public String study1(Model model) {
		model.addAttribute("memberVO", new MemberVO("java","a","아이유","오리"));
		return "step01-text-expression"; 
		//templates/step01-text-expression.html
	}
	
	@RequestMapping("study2")
	public String study2(Model model) {
		model.addAttribute("memberVO", new MemberVO("spring","a","손흥민","토트넘"));
		return "step02-form-obejct-expression"; 
	}
	
	@RequestMapping("study3")
	public String study3(Model model) {
		model.addAttribute("pageNo", 7);
		model.addAttribute("keyword","spring");
		model.addAttribute("orderId",3);
		model.addAttribute("maker", "LG");
		return "step03-link-href-qeuryString";
	}
	
	@RequestMapping("board/list")
	public String study3result1(int pageNo, String keyword) {
		System.out.println(pageNo);
		return "step03-result1-param";
	}
	
	@RequestMapping("order/details")
	public String study3result2(int orderId, String maker) {
		return "step03-result2-param";
	}
	
	@RequestMapping("study4")
	public String study4(HttpSession session) {
		session.setAttribute("member", new MemberVO("thymeleaf", "a", "송강호", "용인"));
		return "step04-session-param";
	}
}