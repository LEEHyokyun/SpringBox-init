package test;

import org.kosta.myproject.config.AppConfig;
import org.kosta.myproject.service.TicketService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//System.out.println(ctx.getBean("kalTicketServiceImpl"));
		System.out.println(ctx.getBean("ticketservice"));
		TicketService service = (TicketService) ctx.getBean("ticketservice");
		service.ticketing();
		ctx.close();
	}
}
