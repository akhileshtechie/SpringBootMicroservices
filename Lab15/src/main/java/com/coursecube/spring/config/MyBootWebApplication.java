package com.coursecube.spring.config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
* @Author : Akhilesh Bhagat
* @company : Java Learning Center
* */
@SpringBootApplication(scanBasePackages = {"com.coursecube.spring"})
@EnableWebMvc
public class MyBootWebApplication extends SpringBootServletInitializer{
public static void main(String[] args) {
SpringApplication.run(MyBootWebApplication.class, args);
}
@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
return application.sources(MyBootWebApplication.class);
}
} 