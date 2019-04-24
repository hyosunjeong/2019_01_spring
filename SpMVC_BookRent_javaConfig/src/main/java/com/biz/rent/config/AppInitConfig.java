package com.biz.rent.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * web.xml의 할 일을 대신할 클래스
 * web.xml에 세팅할 부분을 설정하고 서버가 시작될 때
 * 자동으로 실행하도록 지정한다
 */
public class AppInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	/*
	 * root-context.xml 을 대신할 method
	 * 실질적으로 context-param tag 설정을 대신할 method
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {AppServletConfig.class};
	}

	/*
	 * servlet 설정을 대신할 부분
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RootConfig.class};
	}

	
	/*
	 * web.xml의 appServlet의 servlet-mapping을 대체
	 */
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	
	

}
