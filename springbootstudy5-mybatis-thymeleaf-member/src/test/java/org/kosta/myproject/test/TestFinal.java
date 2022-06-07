package org.kosta.myproject.test;

class Demo {
	private final String ID;
	//상수는 반드시 변수 초기화가 되어야 함
	//생성자를 통한 초기화를 하여 컴파일, 런타임 오류 방지
	public Demo(String id) {
		ID = id;
	}
	
	public String getId() {
		return ID;
	}
}

public class TestFinal {

}
