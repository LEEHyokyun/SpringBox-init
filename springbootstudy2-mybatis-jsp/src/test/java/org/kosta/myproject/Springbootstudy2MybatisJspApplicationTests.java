package org.kosta.myproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kosta.myproject.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springbootstudy2MybatisJspApplicationTests {
	//Controller 생성없이 mapper interface, mapper.xml 생성으로 test 가능
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Test
	void contextLoads() {
		Assertions.assertNotNull(departmentMapper);
	}
	
	@Test
	void getAllDepartmentCount() {
		int count = departmentMapper.getAllDepartmentCount();
		System.out.println(count);
	}

}
