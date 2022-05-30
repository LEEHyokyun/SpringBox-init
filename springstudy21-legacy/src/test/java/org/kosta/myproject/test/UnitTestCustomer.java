package org.kosta.myproject.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.myproject.mapper.CustomerMapper;
import org.kosta.myproject.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * unit test를 위한 java 프레임 워크
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class UnitTestCustomer {
	@Autowired //필드로 주입
	private CustomerMapper customerMapper;
	
	@Test
	public void testDI() {
		Assert.assertNotNull(customerMapper); //customerMapper는 null이 아님을 확신한다, 이를 test한다.
	}
	
	
	  @Test public void getTotalCustomerCount() { //기대값 ,실제값 
		  Assert.assertEquals(1,customerMapper.getTotalCustomerCount()); 
	  }
	 
	
	@Test
	public void findCustomerById() {
		String id = "java";
		CustomerVO cvo = customerMapper.findCustomerById(id);
		Assert.assertNotNull(cvo);
	}
	
	@Test
	public void registerCustomer() {
		CustomerVO unitTestCVO = new CustomerVO("javaqueen", "영희", "용인");
		
		if(customerMapper.findCustomerById(unitTestCVO.getId()) == null) {
			int result = customerMapper.registerCustomer(unitTestCVO);
			Assert.assertEquals(1, result);
		}else {
			System.out.println("가존 고객이 존재: unit test has been completed.");
		}
	}
	
	@Test
	public void findAddressList() {
		String address = "오리";
		List<CustomerVO> list = customerMapper.findAddressList(address);
		
		for(CustomerVO cvo:list) {
			System.out.println(cvo);
		}
	}
	
	@Test
	public void checkDuplicateId() {
		String id = "javahi";
		int result = customerMapper.checkDuplicateId(id);
		
		System.out.println(result);
	}
}
