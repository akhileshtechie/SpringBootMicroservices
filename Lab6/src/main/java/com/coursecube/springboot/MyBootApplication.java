package com.coursecube.springboot;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages= "com.coursecube.springboot")
public class MyBootApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(MyBootApplication.class);

	@Autowired
	private CustomerDAO cdao;

	public static void main(String[] args) {

		SpringApplication.run(MyBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.info("My Boot Application...starts");
		log.debug("My Boot Application...starts");
		
		//1. addCustomer
		log.info("----------------------------------");
		Customer cust1 = new Customer( "sd", "sd@jlc", 9999, "Blore");
		cdao.addCustomer(cust1);

		//2. getAllCustomers
		System.out.println("getAllCustomers");
		List<Customer> list=cdao.getAllCustomers();
		list.forEach(cust -> System.out.println(cust));
		log.info("----------------------------------");
		log.info("My Boot Application...ends");
		log.debug("My Boot Application...ends");
		
	}
}
