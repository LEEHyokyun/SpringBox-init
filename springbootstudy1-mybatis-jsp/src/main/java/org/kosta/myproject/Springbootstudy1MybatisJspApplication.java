package org.kosta.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//context component scan, mapper scan, encoding,... 설정해주는 역할
//Spring boot application 어노테이션이 명기된 해당 하위 프로젝트에 대해서만 component 대상
//component scan과 함께 미리 정의된 bean들에 대한 자동 설정 기능 지원
//Maven Dependencies -> spring-boot-autconfigure-> META-INF -> spring.factroies
//별도 설정할 필요가 없고, 내부적으로 지원한다는 의미이다.
public class Springbootstudy1MybatisJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springbootstudy1MybatisJspApplication.class, args);
	}

}