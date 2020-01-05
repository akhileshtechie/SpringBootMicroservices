package com.coursecube.springboot;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="mydatatab")
public class Customer {
	
	@Id
	@GeneratedValue(
		    strategy= GenerationType.AUTO,
		    generator="native"
		)
	@GenericGenerator(
		    name = "native",
		    strategy = "native"
		)
	@Column(name = "cid")
	private int cid;
	
	@Column(name= "cname")
	private String cname;
	@Column(name= "email")
	private String email;
	@Column(name= "phone")
	private long phone;
	@Column(name= "city")
	private String city;

	public Customer(int cid, String cname, String email, long phone, String city) {
		
		this.cid = cid;
		this.cname = cname;
		this.email = email;
		this.phone = phone;
		this.city = city;
	}
	public Customer( String cname, String email, long phone, String city) {
		
		
		this.cname = cname;
		this.email = email;
		this.phone = phone;
		this.city = city;
	}
	public Customer() {

	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {

		return "" + cid + "\t" + cname + "\t" + email + "\t" + phone + "\t" + city;
	}
}
