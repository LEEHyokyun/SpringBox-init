package org.kosta.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	//최초 실행은 welcom file에 의해 실행(이것도 web.xml의 일종임)
	@RequestMapping("home.do")
	public ModelAndView home() {
		//인자1 : view name
		//인자2 : modelName -> request.setAttribute, name
		//인자3 : modelObject  -> request.setAttribute, object
		return new ModelAndView("index","message","Hello!"); //viewResolver 설정대로 ok.jsp를 실행하게 됨(ok.jsp로 응답)
	}
}
