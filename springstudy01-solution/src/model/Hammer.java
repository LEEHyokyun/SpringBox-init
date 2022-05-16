package model;

public class Hammer implements Tool{
	@Override
	public void work() {
		System.out.println("망치를 사용하여 일을 하였습니다.");
	}
}
