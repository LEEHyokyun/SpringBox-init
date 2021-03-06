package test;

import java.sql.SQLException;

import org.kosta.myproject.config.AppConfig;
import org.kosta.myproject.model.MemberService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {
	public static void main(String[] args) {
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationConfig.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService service = (MemberService) ctx.getBean("memberServiceImpl");
		try {
			System.out.println(service.findMemberById("java"));
			System.out.println(service.getClass());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ctx.close();
	}
}
