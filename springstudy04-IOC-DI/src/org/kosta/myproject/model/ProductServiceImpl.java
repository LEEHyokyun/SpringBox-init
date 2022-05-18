package org.kosta.myproject.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service //비즈니스 계층(Business, Service) - 컴포넌트 계열 어노테이션
public class ProductServiceImpl implements ProductService {
	//의존해야하는 대상의 타입은 반드시 인터페이스 타입으로 명기
	
	private ProductDAO productDAO;
	
	@Autowired //DI 어노테이션..스프링 컨테이너가 매개변수의 데이터 타입에 일치하는 type의 bean을 주입한다.
	//setProducTDAO의 매개변수 데이터 타입인 ProductDAO, 즉 인터페이스 데이터 타입이 주입된다(to bean).
	@Qualifier("productDAOImplVer2")
	@Override
	public void setProductDAO(ProductDAO productDAO) {
		System.out.println("Spring IOC Container로부터 "+productDAO+" bean을 주입받았다.");
		this.productDAO = productDAO;
	}
	
	@Override
	public String findProductById(String id) {
		return productDAO.findProductById(id);
	}
}
