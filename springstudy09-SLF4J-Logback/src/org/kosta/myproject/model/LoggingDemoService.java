package org.kosta.myproject.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingDemoService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	public void testLog() {
		// log.xml 설정파일에 debug 레벨로 설정되어 있으므로
		// debug 상위레벨(debug, info, warn, error)에 대해서만 실행한다.
		logger.trace("trace");
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
	}
	
	public void testLog2(String message, String message2) {
		//SLF4J의 {} = 변수 데이터를 출력, + 연산을 제거하여 성능 개선
		logger.info("info test messga1 {} message2 {}", message, message2);
	}
}
