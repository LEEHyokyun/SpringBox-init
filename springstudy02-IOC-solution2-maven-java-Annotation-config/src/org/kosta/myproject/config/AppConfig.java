package org.kosta.myproject.config;

import org.kosta.myproject.model.Hammer;
import org.kosta.myproject.model.Spade;
import org.kosta.myproject.model.Tool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
//spring 설정 클래스임을 명기(to Spring IoC Container)
public class AppConfig {
	@Bean  //tool 메서드명이 bean id가 되어 IOC Container에 bean으로 등록
	Tool tool() {
		return new Hammer();
	}
	
	@Bean
	Tool tool2() {
		return new Spade();
	}
}
