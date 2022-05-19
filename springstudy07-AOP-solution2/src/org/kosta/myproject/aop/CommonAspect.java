package org.kosta.myproject.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
 
@Aspect
@Component
public class CommonAspect {
	@Before("execution(public * org.kosta.myproject.model.*Service.find*(..))") //대상이 실행되기 전에 공통기능을 정의 //execute, 접근제어자 - return type,메소드계열,매개변수
	public void beforeExecute() {
		System.out.println("**AOP 검색계열 공통 기능**");
	}
}
