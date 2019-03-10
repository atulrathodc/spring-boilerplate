package com.my.common.config;



import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.my.common.controller.CORSFilter;



public class HelloWorldInitializer extends AbstractAnnotationConfigDispatcherServletInitializer /* implements WebApplicationInitializer*/  /*extends AbstractAnnotationConfigDispatcherServletInitializer */{

	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { HelloWorldConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		  return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}
	
	  @Override
    protected Filter[] getServletFilters() {
    	Filter [] singleton = { new CORSFilter()};
    	return singleton;
    }
	
/*	@Override
	public void onStartup(ServletContext container) throws ServletException {
		// TODO Auto-generated method stub
	      XmlWebApplicationContext appContext = 
	    	        new XmlWebApplicationContext();
	      appContext.setConfigLocation("/WEB-INF/mvc-dispatcher-servlet.xml");
	    	      ServletRegistration.Dynamic registration = 
	    	        container.addServlet("dispatcher", 
	    	        new DispatcherServlet(appContext));
	    	      registration.setLoadOnStartup(1);
	    	      registration.addMapping("/");
	    	      
	    	      *//***//*
	    	      
	}*/
/*    @Override
    public void onStartup(ServletContext container) {
        AnnotationConfigWebApplicationContext context
          = new AnnotationConfigWebApplicationContext();
       // appContext.setConfigLocation("/WEB-INF/mvc-dispatcher-servlet.xml");
        context.setConfigLocation("com.mkyong.common.controller");
 
        container.addListener(new ContextLoaderListener(context));
 
        ServletRegistration.Dynamic dispatcher = container
          .addServlet("dispatcher", new DispatcherServlet(context));
         
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }*/
	/* 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { HelloWorldConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
    @Override
    protected Filter[] getServletFilters() {
    	Filter [] singleton = { new CORSFilter()};
    	return singleton;
    }*/

	
 
}