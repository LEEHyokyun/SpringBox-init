package org.kosta.myproject.controller;

import org.kosta.myproject.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	//final, 불변 보장(객체 생성을 통한 주입 필요)
	private final MemberMapper memberMapper;
	
	@Autowired
	public HomeController(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	@RequestMapping(value={"/","home"})
	public String home(Model model) {
		model.addAttribute("count", memberMapper.getTotalMemberCount());
		model.addAttribute("addressList", memberMapper.getAddressList());
		return "home";
	}
}
