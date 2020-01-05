package com.coursecube.springboot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("custDAO")
public class JDBCCustomerDAO implements CustomerDAO {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemp;

	public void addCustomer(Customer cust) {
		String sql = "insert into mydatatab values(:mycid,:mycname,:myemail,:myphone,:mycity)";
		
		Map<String, Object> params=new HashMap<>();
		
		params.put("mycid", cust.getCid());
		params.put("mycname", cust.getCname());
		params.put("myemail", cust.getEmail());
		params.put("myphone", cust.getPhone());
		params.put("mycity", cust.getCity());
		
		
		jdbcTemp.update(sql, params);

	}

	public List<Customer> getAllCustomers() {
		String sql="select * from customer";
		Map<String, Object> params=new HashMap<>();
		
		return jdbcTemp.query(sql,params, new CustomerRowMapper());
	}

}
