package org.kosta.myproject.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //Spring 설정 class임을 IOC Container에 명기
@ComponentScan("org.kosta.myproject") //지정 패키지의 하위 클래스들을 스캔, 컴포넌트 계열 클래스들을 bean 등록
public class AppConfig {

}
