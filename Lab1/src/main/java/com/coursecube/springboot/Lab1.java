package com.coursecube.springboot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lab1 {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JLCConfig.class);
		CustomerDAO cdao = (CustomerDAO) ctx.getBean("custDAO");

		// 1. addCustomer
		Customer cust1 = new Customer(114, "AK", "ak@jlc", 9779, "HYBD");
		cdao.addCustomer(cust1);
		System.out.println("Hello World end here!");
	}
}
