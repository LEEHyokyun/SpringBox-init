package org.kosta.myproject.service;

import org.kosta.myproject.dao.TicketDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ticketservice")
public class AsianaTicketServiceImpl implements TicketService {
	@Autowired 
	//DI 어노테이션, 선언한 타입에 맞는 객체를 IOC Container에 주입
	private TicketDAO ticketDAO;
	@Override
	public void ticketing() {
		// TODO Auto-generated method stub
		System.out.println("아시아나 티켓 서비스");
		ticketDAO.ticketing();
	}

}
