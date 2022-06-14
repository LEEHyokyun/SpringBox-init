package org.kosta.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("simple-rest")
	public String simpleRestTest() {
		return "simple-rest";
	}
}