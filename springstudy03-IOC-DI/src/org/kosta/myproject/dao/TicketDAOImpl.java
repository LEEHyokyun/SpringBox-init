package org.kosta.myproject.dao;

import org.springframework.stereotype.Component;

@Component("ticketService")
public class TicketDAOImpl implements TicketDAO {
	@Override
	public void ticketing() {
		System.out.println("DB에 티겟 정보를 저장하였습니다.");
	}
}
