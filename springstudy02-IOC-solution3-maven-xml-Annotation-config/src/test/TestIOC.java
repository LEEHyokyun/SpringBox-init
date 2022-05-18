package test;

import org.kosta.myproject.model.Tool;
import org.kosta.myproject.model.Tool;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Tool tool = (Tool) ctx.getBean("tool");
		tool.work();
		ctx.close();
	}
}
