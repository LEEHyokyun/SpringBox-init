package test;

import org.kosta.myproject.config.AppConfig;
import org.kosta.myproject.model.MemberService;
import org.kosta.myproject.model.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestIOC {
	/*
	 * 현재 시스템에서 서비스 중인 회원관리, 상품관리를 대상으로 
	 * find 계열의 메소드 실행시 언제 실행되는지, 검색 키워드를 특정 파일(report.log)에 로깅
	 * 로깅되어야 하는 필수 정보는 실제 core class, 메소드 명, 실행시간, 검색키워드 기록
	 * 
	 * 1안) 직접 각 core에 코드 삽입
	 * 2안) AOP를 적용하여 공통 기능을 개별 모듈로 작성하여 삽입, java log 기술 이용!
	 * 	ㄴ Log4j, Logback 등
	 *  ㄴ maven.pom.xml, Logging 관련 라이브러리 추가 > SLF4J(인터페이스), logback(구현체)
	 *  ㄴ logging 설정파일인 logback.xml 추가
	 *  ㄴ 각 서비스의 기능에 따라 로깅처리
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
