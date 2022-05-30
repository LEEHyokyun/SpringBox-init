package org.kosta.myproject.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * web.xml의 역할
 * - dispatcher Servlet 설정
 * - url pattern 정의
 *  - CharachterEncodingFilter 설정
 */
public class WebAppConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	//root-context.xml
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RootContextConfig.class};
	}

	@Override
	//servelt-context.xml
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletContextConfig.class};
	}

	@Override
	//servlet mapping(url pattern)
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	@Override
	//encoding
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("utf-8");
		
		return new Filter[] {encodingFilter};
	}

}
