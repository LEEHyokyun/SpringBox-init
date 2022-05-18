package test;

import org.kosta.myproject.model.Tool;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
	public static void main(String[] args) {
		//IOC Container 생성, spring 설정 xml을 로딩하여 tool bean생성
		//IOC Container는 singleton이다.
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Tool tool = (Tool) ctx.getBean("tool");
		tool.work();
		ctx.close();
	}
}
