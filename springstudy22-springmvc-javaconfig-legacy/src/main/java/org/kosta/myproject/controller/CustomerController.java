package org.kosta.myproject.controller;

import java.util.List;
import java.util.Map;

import org.kosta.myproject.mapper.CustomerMapper;
import org.kosta.myproject.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {
	private CustomerMapper customerMapper;
	
	@Autowired
	public CustomerController(CustomerMapper customerMapper) {
		super();
		this.customerMapper = customerMapper;
	}
	
	@RequestMapping("findCustomerById")
	public String findCustomerById(String id, Model model) {
		CustomerVO cvo = customerMapper.findCustomerById(id);
		model.addAttribute("customerVO",cvo);
		
		if(cvo != null)
			return "findbyid-success";
		else
			return "findbyid-fail";
	}
	
	@PostMapping("registerCustomer")
	public String registerCustomer(CustomerVO cvo) {
		CustomerVO cvoResult = customerMapper.findCustomerById(cvo.getId());
		
		if(cvoResult == null) {
			customerMapper.registerCustomer(cvo);
			return "redirect:registerCustomerRedirected";
		}else
			return "duplicate-id";
	}
	
	@RequestMapping("registerCustomerRedirected")
	public String registerCustomerRedirected() {
		return "register-result";
	}
	
	@GetMapping("findCustomerListByAddress")
	public String findCustomerListByAddress(String address, Model model) {
		System.out.println(address);
		
		List<CustomerVO> list = customerMapper.findAddressList(address);
		model.addAttribute("address", address);
		model.addAttribute("customerList", list);
		
		return "findbyaddress-list";
	}
	
	@RequestMapping("registerForm")
	public String registerForm() {
		return "register-form-ajax";
	}
	
	@RequestMapping("checkDuplicateId") //for ajax
	@ResponseBody
	public String checkDuplicateId(String id) {
		String checkIdResult = "fail";
		
		int result = customerMapper.checkDuplicateId(id);
		if(result == 0)
			checkIdResult = "ok";
		
		return checkIdResult;
		/*
		 * 삼항 연산자
		 * return (result==0) ? "ok":"fail";
		 */
	}
	
	@PostMapping("registerCustomerByAjax")
	public String registerCustomerByAjax(CustomerVO cvo) {
		
		customerMapper.registerCustomer(cvo);
		
		return "redirect:registerResult";
	}
	
	@RequestMapping("registerResult")
	public String registerResult() {
		return "register-result";
	}
}
