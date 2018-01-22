package com.shubham.ecommercefrontend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan({ "com.shubham.ecommercefrontend", "com.shubham.ecommercebackend" })
@EnableWebMvc
public class DispatcherConfig extends WebMvcConfigurerAdapter {

	private int maxUploadSizeInMb = 4 * 1024 * 1024; // 4 MB
	
	@Bean
	public ViewResolver configureViewResolver() {
		InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
		viewResolve.setPrefix("/WEB-INF/views/");
		viewResolve.setSuffix(".jsp");

		return viewResolve;
	}

	 @Bean
	    public CommonsMultipartResolver multipartResolver() {

	        CommonsMultipartResolver cmr = new CommonsMultipartResolver();
	        cmr.setMaxUploadSize(maxUploadSizeInMb * 2);
	        cmr.setMaxUploadSizePerFile(maxUploadSizeInMb); //bytes
	        return cmr;

	    }
	
	
	/*@Bean
	public MultipartResolver multipartResolver() {
		StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
		return resolver;
	}*/

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/assets/");
	}

}
