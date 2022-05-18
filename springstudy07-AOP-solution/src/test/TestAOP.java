package test;

import org.kosta.myproject.config.AppConfig;
import org.kosta.myproject.model.MemberService;
import org.kosta.myproject.model.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAOP {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService ms = (MemberService) ctx.getBean("memberServiceImpl"); //DL, look up방식
		ProductService ps = (ProductService) ctx.getBean("productServiceImpl"); //DL, loop up방식
		
		ms.findMemberByAddress();
		ps.findProductById();
		/*
		 * 각 서비스의 find 계열 메소드에 대해 별도 작업이 필요할 경우
		 *  ㄴ 검색어에 대한 기록, 로깅, 이력관리 등
		 *  ㄴ 2) AOP를 통해 생산성 및 유지보수성을 높인 로직으로 구성
		 *  	* maven을 통해 AOP 라이브러리 추가
		 *  	* 별도 모듈에서 공통로직을 정의
		 *  		ㄴ org.kosta.myproject.aop.CommonAspect
		 *  	* AOP설정 및 AppConfig에 추가 
		 *  	* 공통로직이 적용된 상태로 실행되는 것을 확인
		 */		
		ctx.close();
	}
}
