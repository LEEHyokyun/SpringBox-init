package test;

import org.kosta.myproject.config.AppConfig;
import org.kosta.myproject.model.MemberService;
import org.kosta.myproject.model.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestIOC {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService ms = (MemberService) ctx.getBean("memberServiceImpl"); //DL, look up방식
		ProductService ps = (ProductService) ctx.getBean("productServiceImpl"); //DL, loop up방식
		
		ms.findMemberByAddress();
		/*
		 * 각 서비스의 find 계열 메소드에 대해 별도 작업이 필요할 경우
		 *  ㄴ 검색어에 대한 기록, 로깅, 이력관리 등
		 *  ㄴ 1) 전체 서비스에서 find 계열 메소드에 직접 코드를 삽입한다(비효율적인 방식)
		 *  	ㄴ 반복작업이 증가, 생산성 감소, common 로직 변경시 일괄변경필요(유지보수성 감소)
		 * 
		 */
		ctx.close();
	}
}
