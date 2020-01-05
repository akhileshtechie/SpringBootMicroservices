package com.coursecube.spring.config;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.*;

/*
* @Author : Akhilesh Bhagat
* @company : Java Learning Center
* */

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.coursecube.spring" })
@EntityScan(basePackages = { "com.coursecube.spring.entity" })
public class JLCWebConfig {
 @Bean
 public InternalResourceViewResolver viewResolver() {
 InternalResourceViewResolver viewResolver = new
InternalResourceViewResolver();
 viewResolver.setViewClass(JstlView.class);
 viewResolver.setPrefix("/WEB-INF/myjsps/");
 viewResolver.setSuffix(".jsp");
 return viewResolver;
 }
} 