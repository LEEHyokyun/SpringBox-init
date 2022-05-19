package test;

import org.kosta.myproject.config.AppConfig;
import org.kosta.myproject.model.MemberService;
import org.kosta.myproject.model.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAOP {
	/*
	 * 최종 logging 구성 - AOP와 함께 연동하기
	 * maven pom.xml 설정 및 라이브러리 추가
	 * org.kosta.myproject.aop.KeyWordLoggingAspect에
	 * AOP Cross Cutting Concern logic 정의 클래스 구현(Aspect, After Advice, Pointcut)
	 * 	ㄴ 공통관심사/횡단관심사 로직을 적용 대상의 메소드에 맞게 로직 구성
	 * Spring Config인 AppConfig에 AOP 설정
	 */	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService ms = (MemberService) ctx.getBean("memberServiceImpl");
		ProductService ps = (ProductService) ctx.getBean("productServiceImpl");
		System.out.println(ms.getClass());
		System.out.println(ps.getClass());
		ms.findMemberListByAddress("java");
		ps.findProductListByMaker("java");
		System.out.println("***************************");
		ctx.close();
	}
}
