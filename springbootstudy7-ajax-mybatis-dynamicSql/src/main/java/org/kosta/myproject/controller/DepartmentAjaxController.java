package org.kosta.myproject.controller;

import java.util.List;
import java.util.Map;

import org.kosta.myproject.mapper.DepartmentMapper;
import org.kosta.myproject.vo.DepartmentVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor //lombok, final 상수에 대한 생성자
public class DepartmentAjaxController {
	private final DepartmentMapper departmentMapper;
	
	@GetMapping("testAjax")
	@ResponseBody
	public String testAjax(String userId) {
		return "hello ajax";
	}
	
	@GetMapping("findDepartmentByNo")
	@ResponseBody
	public DepartmentVO findDepartmentByNo(int departmentNo) {
		//VO가 spring 내부적으로, json object로 변환하여 전달
		return departmentMapper.findDepartmentByNo(departmentNo);
	}
	
	@GetMapping("findDepartmentMapByNo")
	@ResponseBody
	public Map<String, Object> findDepartmentMapByNo(int departmentNo){
		return departmentMapper.findDepartmentMapByNo(departmentNo);
	}
	
	@GetMapping("findAllDepartmentList")
	@ResponseBody
	public List<DepartmentVO> findAllDepartmentList(){
		return departmentMapper.findAllDepartmentList();
	}
}
