package com.coursecube.springboot;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
class JpaCustomerDAO implements CustomerDAO {
	
	
	@PersistenceContext
	EntityManager entityManager;

	public void addCustomer(Customer cust) {
		entityManager.persist(cust);

	}
	/*
	 * public List<Customer> getAllCustomers() { String jpaql="from Customer cust";
	 * 
	 * return entityManager.createQuery(jpaql,Customer.class).getResultList(); }
	 */

}
