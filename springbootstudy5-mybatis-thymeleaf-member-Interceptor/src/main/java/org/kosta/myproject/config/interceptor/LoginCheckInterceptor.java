package org.kosta.myproject.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor{
	private Logger log = LoggerFactory.getLogger(getClass());
	@Override
	//컨트롤러 실행 전 시행하는 정책
	//true 반환 -> 컨트롤러 실행
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession(false);
		if(session!=null && session.getAttribute("mvo") != null) {
			//log.info("interceptor test : authorized, {}", request.getRequestURI());
			return true; //컨트롤러 실행
		}else {
			//log.warn("interceptor test : not authorized, {}", request.getRequestURI());
			response.sendRedirect("/");
			return false; //컨트롤러 미실행
		}
	}
	/*
	 * Spring Handler Interceptor : 

DispatcherServlet이 해당 컨트롤러를 호출하기 전,후에 요청과 응답을 제어하는 역할을 한다. 

​

컨트롤러 실행전  preHandle(request,response,handler) 

컨트롤러 실행후 postHandle(request,response,handler)

응답완료 afterCompletion(request,response,handler)

Spring에서 제공하는 HandlerInterceptorAdapter 를 상속받아 

위와 같은 메서드를 오버라이딩해서 사용한다

​

 DispatcherServlet -- HandlerInterceptor -- Handler(Controller)

                           컨트롤러 영역의

                          공통관심사항을 일괄처리

​

   로그인 인증여부를 체크해서 

   로그인되어 있지 않은 사용자의 요청은

   요청에 해당하는 핸들러(컨트롤러)를 실행하지  않고 

   home으로 redirect 시킨다 


	 */
}
