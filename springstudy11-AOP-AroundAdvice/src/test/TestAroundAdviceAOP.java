package test;

import java.sql.SQLException;

import org.kosta.myproject.config.AppConfig;
import org.kosta.myproject.model.InventoryException;
import org.kosta.myproject.model.PersonService;
import org.kosta.myproject.model.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAroundAdviceAOP {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		PersonService personService = (PersonService) ctx.getBean("personService");
		ProductService productService = (ProductService) ctx.getBean("productService");
		personService.register();
		System.out.println(personService.getNick());
		productService.register("도미노피자");
		System.out.println(productService.getMaker());
		System.out.println("*****************");
		System.out.println("특정 예외 발생시, 공통 로직 실행");
		try {
			productService.buyProduct(1);
			productService.sellProduct(12); //AOP 적용 대상
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InventoryException e) {
			// TODO Auto-generated catch block
			System.out.println("main:"+e.getMessage());
		}
		ctx.close();
	}
}
