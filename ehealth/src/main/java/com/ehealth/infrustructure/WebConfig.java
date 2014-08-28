package com.ehealth.infrustructure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@ComponentScan("com.ehealth")
public class WebConfig extends WebMvcConfigurerAdapter {
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/login").setViewName("login");
	        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	    }
}
