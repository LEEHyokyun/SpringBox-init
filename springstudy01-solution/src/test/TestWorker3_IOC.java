package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Tool;

public class TestWorker3_IOC {
	public static void main(String[] args) {
		/*
		 * IOC 구현 방식이 적용되었을 경우
		 * 1. 대상 컴포넌트(의존대상)을 계층구조화
		 * 	- tool interface정의 및 하위 구현체로 Hammer, Spade 구성
		 * 2. Spring IOC Container(Spring 실행시 동작)가 로딩할 설정을 명시
		 * 	ㄴ xml, annotation
		 * 3. SPring IOC Container 실행하여 프로그램 구동
		 */
		/*
		 * Spade tool = new Spade(); tool.work();
		 */
		/*
		 * Spring IOC Container 실행 및 호출
		 * 이때 생성자에 spring 설정파일명을 등록
		 */
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ioc.xml");
		//container
		Tool tool = (Tool) ctx.getBean("tool");
		tool.work();
		ctx.close();
	}
}
