package org.kosta.myproject.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kosta.myproject.mapper.EmployeeMapper;
import org.kosta.myproject.vo.DepartmentVO;
import org.kosta.myproject.vo.EmployeeVO;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class EmployeeUnitTest {
	@Resource
	EmployeeMapper employeeMapper;
	
	@Test
	void mapper() {
		Assertions.assertNotNull(employeeMapper);
	}
	
	@Test
	void findEmployeeByNo() {
		int employeeNo = 1;
		EmployeeVO evo = employeeMapper.findEmployeeByNo(employeeNo);
		log.debug("employee: {}", evo);
	}
	
	@Test
	/*
	 * MyBatis Dynamic SQL
	 */
	void findEmployeeListDynamicSql() {
		EmployeeVO employeeVO = new EmployeeVO();
		List<EmployeeVO> list = employeeMapper.findEmployeeListDynamicSql(employeeVO);
		for(EmployeeVO vo:list) {
			log.debug("employee : {}", vo);
		}
	}
	
	@Test
	void findEmployeeListDynamicSql2() {
		EmployeeVO employeeVO = new EmployeeVO();
		DepartmentVO departmentVO = new DepartmentVO();
		departmentVO.setDepartmentName("유");
		employeeVO.setDepartmentVO(departmentVO);
		List<EmployeeVO> list = employeeMapper.findEmployeeListDynamicSql(employeeVO);
		for(EmployeeVO vo:list) 
			log.debug("employee : {}", vo);
	}
	
	@Test
	void findEmployeeListDynamicSql3() {
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setName("유");
		List<EmployeeVO> list = employeeMapper.findEmployeeListDynamicSql(employeeVO);
		for(EmployeeVO vo:list) 
			log.debug("employee : {}", vo);
	}
	
	@Test
	void findEmployeeListDynamicSql4() {
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setName("두");
		DepartmentVO departmentVO = new DepartmentVO();
		departmentVO.setDepartmentNo(20);
		employeeVO.setDepartmentVO(departmentVO);
		List<EmployeeVO> list = employeeMapper.findEmployeeListDynamicSql(employeeVO);
		for(EmployeeVO vo:list) 
			log.debug("employee : {}", vo);
	}
}
