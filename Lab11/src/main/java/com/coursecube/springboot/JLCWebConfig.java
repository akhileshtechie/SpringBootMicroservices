package com.coursecube.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@SpringBootApplication
public class JLCWebConfig {

	@Bean
public 	ViewResolver viewResolver() {
	
	InternalResourceViewResolver resolver= new InternalResourceViewResolver();
	resolver.setPrefix("/WEB-INF/view/");
	resolver.setSuffix(".jsp");
	resolver.setViewClass(JstlView.class);
		return resolver;
	}
}
