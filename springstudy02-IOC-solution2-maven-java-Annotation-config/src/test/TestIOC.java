package test;

import org.kosta.myproject.config.AppConfig;
import org.kosta.myproject.model.Tool;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class TestIOC {
	public static void main(String[] args) {
		//java 기반 설정 클래스를 로딩
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Tool tool = (Tool) ctx.getBean("tool");
		tool.work();
		//ctx.close();
		
		Tool tool2 = (Tool) ctx.getBean("tool2");
		tool2.work();
		ctx.close();
	}
}
