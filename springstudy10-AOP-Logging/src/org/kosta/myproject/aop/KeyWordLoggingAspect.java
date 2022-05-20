package org.kosta.myproject.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class KeyWordLoggingAspect {
		/*
		 * after Advice, core 실행 후 적용되는 advice
		 * pointcut : AOP 공통 관심사를 적용하는 대상 지정
		 * 
		 * public : 메소드 접근 제어자
		 * * : 리턴 타입
		 * org.kosta.myproject.model.. : 하위 모든 패키지(. 하나-> 하위 패키지)
		 * *Service : Service로 마치는 인터페이스, 클래스
		 * find* : find로 시작하는 메서드
		 * (..) : 매개변수 0~*
		 */
		private Logger logger = LoggerFactory.getLogger(getClass());
		//After advice, 특정 시점에 공통 로직 기능을 적용, point cut으로 적용 클래스 및 메소드를 정의
		//여기서 정의한 log를 AOP 및 IOC Container를 통해 적용
		//기본적으로 IOC Container의 proxy 객체에서 인터페이스를 bean을 불러온다
		//인터페이스가 없을 경우엔 proxy를 별도로 상속받은 객체를 불러온다
		@After("execution(public * org.kosta.myproject.model..*Service.find*(..))")
		public void logging(JoinPoint point) {
			//JoinPoint - target 정보를 포함하는 객체
			//Spring IOC Container가 제공하는 joinpoint 객체로 실제 core의 클래스, 메소드 명 반환
			String className = point.getTarget().getClass().getName();
			String method = point.getSignature().getName();
			
			//target core에서 전달받은 인자들을 저장하는 배열이다.
			//검색어와 연관!!
			Object params[] = point.getArgs();
			String keyword = "";
			for(int i=-0;i<params.length;i++) {
				keyword = keyword + params[i] + " ";
			}
			
			logger.info("core class : {}, method name : {}, keyword: {}",className, method, keyword);
		}
	
}
