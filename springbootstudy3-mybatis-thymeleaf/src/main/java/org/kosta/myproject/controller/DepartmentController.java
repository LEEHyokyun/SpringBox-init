package org.kosta.myproject.controller;

import org.kosta.myproject.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepartmentController {
	private DepartmentMapper departmentMapper;
	
	@Autowired
	//bean 객체를 IOC, 별도 객체 생성없이 static 하듯 해당 메소드 사용 가능
	public DepartmentController(DepartmentMapper departmentMapper) {
		super();
		this.departmentMapper = departmentMapper;
	}
	
	@RequestMapping("getAllDepartmentCount")
	public String getAllDepartmentCount(Model model) {
		int count = departmentMapper.getAllDepartmentCount();
		model.addAttribute("totalDepartmentCount", count);
		//thymeleaf의 경우 html 확장자가 응답
		return "department-count";
	}
}
