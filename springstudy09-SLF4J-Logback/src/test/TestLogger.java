package test;

import org.kosta.myproject.model.LoggingDemoService;

public class TestLogger {
	public static void main(String[] args) {
		LoggingDemoService service = new LoggingDemoService();
		service.testLog();
		service.testLog2("안녕", "오늘");
	}
}
