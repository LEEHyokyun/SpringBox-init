package org.kosta.myproject.service;

import org.springframework.stereotype.Component;
//별도 이름을 명시하지 않을 경우, 소문자로 시작하는 클래스명이 bean name이 된다.
//@Component("ticketservice")
//IOC, DL(Dependency Lookup) : 컴포넌트 검색을 통해 객체 확보
public class KalTicketServiceImpl implements TicketService {
	@Override
	public void ticketing() {
		System.out.println("대한항공 티켓 서비스");
	}
}
