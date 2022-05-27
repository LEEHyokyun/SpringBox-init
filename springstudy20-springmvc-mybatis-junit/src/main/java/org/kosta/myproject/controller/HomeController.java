package org.kosta.myproject.controller;

import java.util.List;
import java.util.Map;

import org.kosta.myproject.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private CustomerMapper customerMapper;
	
	//DI, DI 주입방식은 생성자를 통한 주입을 권장(mapperProxy를 주입받는다)
	@Autowired
	public HomeController(CustomerMapper customerMapper) {
		super();
		this.customerMapper = customerMapper;
	}
	
	@RequestMapping("home.do")
	public String home(Model model) {
		model.addAttribute("totalCustomerCount", customerMapper.getTotalCustomerCount());
		
		List<String> list = customerMapper.getTotalAddressList();
		model.addAttribute("addressList", list);
		return "home"; //view name
	}
}
