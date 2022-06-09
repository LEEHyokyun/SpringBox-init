package org.kosta.myproject.config.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class HandlerInterceptorConfigure implements WebMvcConfigurer{
	private final LoginCheckInterceptor interceptor;
	
	@Autowired
	public HandlerInterceptorConfigure(LoginCheckInterceptor interceptor) {
		super();
		this.interceptor = interceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
			//현재 경로 및 하위 모든 경로에 인터셉트 적용
			/// = context path
		registry.addInterceptor(interceptor)
		.addPathPatterns("/**")
			// 로그인 미인증 시에도 처리 가능한 경로 명기(home, 정적 경로)
		.excludePathPatterns("/","/home","/images/**","/scripts/**","/css/**","/login","/registerMember*");
	}
}
