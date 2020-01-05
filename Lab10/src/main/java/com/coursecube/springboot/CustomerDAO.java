package com.coursecube.springboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer, Integer>{
public List<Customer> findCustomerByCname(String name);

}
