package org.kosta.myproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kosta.myproject.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springbootstudy1MybatisJspApplicationTests {
	@Autowired
	private ProductMapper productMapper;
	@Test
	void contextLoads() {
		Assertions.assertNotNull(productMapper);
	}
	
	@Test
	public void getTotalProductCount() {
		int count = productMapper.getTotalProductCount();
		System.out.println(count);
	}
	
	@Test
	public void findProductByNo() {
		int productNo = 1;
		Assertions.assertNotNull(productMapper.findProductByNo(productNo));
		System.out.println(productMapper.findProductByNo(productNo));
	}
}