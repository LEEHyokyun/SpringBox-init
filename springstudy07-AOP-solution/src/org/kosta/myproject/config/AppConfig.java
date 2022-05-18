package org.kosta.myproject.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.kosta.myproject")
@EnableAspectJAutoProxy //AOP 지원 의존객체 생성
public class AppConfig {
	
}
