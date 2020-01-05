package com.coursecube.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = { "com.coursecube.springboot" })
@EnableWebMvc
public class MyBootWebApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MyBootWebApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(MyBootWebApplication.class);
	}

}
