package com.ehealth.infrustructure;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class ApplicationInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(SecurityConfig.class);
        context.refresh();
        servletContext.addListener(new ContextLoaderListener(context));
        context = new AnnotationConfigWebApplicationContext();
		context.register(WebConfig.class);
        context.refresh();
        servletContext.addListener(new ContextLoaderListener(context));
        
       
	}
    

}
