package com.coursecube.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
class HibernateCustomerDAO implements CustomerDAO {
	
	@Autowired
	HibernateTemplate hibernateTemp;

	public void addCustomer(Customer cust) {
		hibernateTemp.save(cust);

	}

	public List<Customer> getAllCustomers() {

		return hibernateTemp.loadAll(Customer.class);
	}

}
