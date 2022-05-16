package test;

import model.Hammer;
import model.Spade;

public class TestWorker1 {
	public static void main(String[] args) {
		/*
		 * 기존 일반적인 제어방식
		 * 사용하는 측에서 객체를 생성
		 */
		Hammer tool = new Hammer();
		tool.work();
		
		/*
		 * 도구 Hammer -> Spade 변경시
		 * 생성하는 객체를 변경 -> 컴포넌트 결합도가 높은 상태
		 */
		Spade tool2 = new Spade();
		tool2.work();
		/*
		 * tool(bean, 컴포넌트, 인스턴스 등)이 변경되어도
		 * 사용하는 측에서 별도 변화가 필요없도록 저결합도 상태로
		 * 만들기 위해 IOC 기법을 적용
		 */
	}
}
