package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class DemoStopWatchService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public void getList() {
		//Spring stopwatch Test
		/******************************/
		//Cross Cutting Concern
		StopWatch watch = new StopWatch();
		watch.start();
		/******************************/
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Core : 리스트를 조회");
		/******************************/
		//Cross Cutting Concern
		watch.stop();
		long time = watch.getTotalTimeMillis();
		if(time>=500 && time <1000) {
			//warn logging
			logger.warn("{} {} time: {}", getClass().getName(), "getList", time);
		}else{if(time >= 1000) {
			//error logging
			logger.error("{} {} time: {}", getClass().getName(), "getList", time);
		}
		/******************************/
	}
	}
}
