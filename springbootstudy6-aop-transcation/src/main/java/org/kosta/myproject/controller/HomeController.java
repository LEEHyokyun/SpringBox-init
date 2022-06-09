package org.kosta.myproject.controller;

import org.kosta.myproject.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //lombock, final 상수에 대한 생성자 생성
public class HomeController {
	private final MemberService memberService;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("totalMemberCount", memberService.getTotalMemberCount());
		return "index";
	}
}
