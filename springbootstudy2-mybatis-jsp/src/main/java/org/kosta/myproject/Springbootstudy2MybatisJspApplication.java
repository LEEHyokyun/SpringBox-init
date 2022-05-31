package org.kosta.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//component scan, auto configuraton, IOC DI AOP MVC DBCP MyBatis JUnit Security
//bean 생성 관리 및 자동 설정 등에 대한 기능 지원
public class Springbootstudy2MybatisJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springbootstudy2MybatisJspApplication.class, args);
	}

}
