package org.kosta.myproject.controller;

import java.util.List;

import org.kosta.myproject.mapper.DepartmentMapper;
import org.kosta.myproject.mapper.EmployeeMapper;
import org.kosta.myproject.vo.EmployeeVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {
	private final DepartmentMapper departmentMapper;
	private final EmployeeMapper employeeMapper;
	
	@RequestMapping("employeeAjaxTest")
	public String employeeAjaxTest(Model model) {
		model.addAttribute("deptList", departmentMapper.findAllDepartmentList());
		log.info("emplyeeAjaxTest");
		return "employee/list";
	}
	
	@RequestMapping("employeeAjaxTest2")
	public String employeeAjaxTest2(Model model) {
		model.addAttribute("deptList", departmentMapper.findAllDepartmentList());
		log.info("emplyeeAjaxTest2");
		return "employee/list2";
	}
	
	@RequestMapping("findEmployeeListDynamicSql")
	@ResponseBody //ajax(JSON Array)
	public List<EmployeeVO> findEmployeeListDynamicSql(EmployeeVO employeeVO) {
		log.debug("param: {}", employeeVO); // 사원명 name, 부서번호 departmentNo 할당 확인
		return employeeMapper.findEmployeeListDynamicSql(employeeVO); //list -> json Array
	}
	
	//controller에서 html 요소를 받아 처리, responsebody 필요 없음
	@RequestMapping("findEmployeeListDynamicSql2")
	public String findEmployeeListDynamicSql2(EmployeeVO employeeVO, Model model) {
		model.addAttribute("empList", employeeMapper.findEmployeeListDynamicSql(employeeVO));
		return "employee/list2 :: #empTbody"; //list -> json Array
	}
}
