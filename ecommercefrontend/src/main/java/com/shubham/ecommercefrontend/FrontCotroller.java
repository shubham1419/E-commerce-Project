package com.shubham.ecommercefrontend;

import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FrontCotroller extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] {DispatcherConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	 @Override
	    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
	        boolean done = registration.setInitParameter("throwExceptionIfNoHandlerFound", "true"); // -> true
	        if(!done) throw new RuntimeException();
	    }

}
