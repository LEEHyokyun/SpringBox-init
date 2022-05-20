package org.kosta.myproject.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.kosta.myproject.model.InventoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundLoggingAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());
	//Around Advice : before / after 실행
	@Around("within(org.kosta.myproject.model.*)")
	public Object aroundLogging(ProceedingJoinPoint point) throws Throwable { //joinpoint 설정 - target core를 실행하는 메소드를 내장
		logger.info("**AOP before Advice**");
		Object retValue = null;
		try {
			retValue = point.proceed();
			if(retValue != null)
				logger.info("**AOP After Advice: return value is : {}", retValue);
		}catch(InventoryException ie) {
			logger.info("AOP After Thrwoing Advice: {}, 공급처에 메시지를 전달합니다.",ie.getMessage());
			//다시 exception throw..main에서 최종 처리
			throw ie;
		}finally {
			//항상 실행
			String className = point.getTarget().getClass().getName();
			String methodName = point.getTarget().getClass().getName();
			logger.info("**AOP After advice : {}, {}**",className,methodName);
		}
		return retValue;
	}
}
