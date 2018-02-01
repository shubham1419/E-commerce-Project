package com.shubham.ecommercefrontend;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;

@Configuration
	public class WebFlow extends AbstractFlowConfiguration {
	 
	    @Autowired
	    private DispatcherConfig webMvcConfig;
	 
	    @Bean
	    public FlowDefinitionRegistry flowRegistry() {
	        return getFlowDefinitionRegistryBuilder(flowBuilderServices())
	           .addFlowLocationPattern("/WEB-INF/views/flows/**/*-flow.xml")
	          .build();
	    }
	 
	    @Bean
	    public FlowExecutor flowExecutor() {
	        return getFlowExecutorBuilder(flowRegistry()).build();
	    }
	 
	    @Bean
	    public FlowBuilderServices flowBuilderServices() {
	        return getFlowBuilderServicesBuilder()
	          .setViewFactoryCreator(mvcViewFactoryCreator())
	          .setDevelopmentMode(true).build();
	    }
	 
	    @Bean
	    public MvcViewFactoryCreator mvcViewFactoryCreator() {
	        MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
	        factoryCreator.setViewResolvers(
	          Collections.singletonList(this.webMvcConfig.configureViewResolver()));
	        factoryCreator.setUseSpringBeanBinding(true);
	        return factoryCreator;
	    }
	

}
