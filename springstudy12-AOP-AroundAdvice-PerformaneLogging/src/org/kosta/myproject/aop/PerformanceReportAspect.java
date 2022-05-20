package org.kosta.myproject.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class PerformanceReportAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Around("execution(* org.kosta.myproject.model..*Service.*(..))")
	public Object timeLogging(ProceedingJoinPoint point) throws Throwable{
		StopWatch watch = new StopWatch();
		watch.start();
		Object retValue = null;
		System.out.println("***AOP 공통 기능 실행***");
		try {
			//point - target core의 method 내장
			retValue = point.proceed();
		}finally {
			//method 실행 완료까지 실행 시간 계산
			watch.stop();
			long time = watch.getTotalTimeMillis();
			if(time >=500 && time < 1000) {
				logger.warn("warning! : {} {} time: {}", point.getClass().getName(), point.getSignature().getName(), time);
			} else if(time >= 1000) {
				logger.warn("time error! : {} {} time: {}", point.getClass().getName(), point.getSignature().getName(), time);
			}
		}
		/*
		 * 메소드는 자체적으로 실행하고(point proceed)
		 * 실행 후 return type은 저장하고, 이를 Object 형태로 반환하여 최종적으로 main에서 실행
		 */
		return retValue;
	}
}
