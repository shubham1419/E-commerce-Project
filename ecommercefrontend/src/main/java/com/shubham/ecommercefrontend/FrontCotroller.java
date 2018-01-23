package com.shubham.ecommercefrontend;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class FrontCotroller extends AbstractAnnotationConfigDispatcherServletInitializer {

	
	private String TMP_FOLDER = "/tmp"; 
    private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024; 
	
	
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
	 
	 @Override
	    public void onStartup(ServletContext sc) throws ServletException {
	         
	        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER, 
	          MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
	         
	        appServlet.setMultipartConfig(multipartConfigElement);
	    }

}
