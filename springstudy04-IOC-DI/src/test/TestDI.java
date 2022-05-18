package test;

import org.kosta.myproject.config.AppConfig;
import org.kosta.myproject.model.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDI {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class); //설정정보에서 구성한 하위 패키지에서 해당하는 컴포넌트 탐색
		ProductService service = (ProductService) ctx.getBean("productServiceImpl");
		String info = service.findProductById("1");
		System.out.println(info);
		ctx.close();
	}
}
