package com.coursecube.spring.entity;

import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
* @Author : Akhilesh Bhagat
* @company : Java Learning Center
* */
@Entity
@Table(name = "mybooks")
public class Book {
	@Id
	@Column(name = "bid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bid;

	@Column(name = "bname")
	@NotEmpty(message = "Book Name is Required")
	@Size(min = 5, max = 20, message = "Name length must be between 5 and 20")
	private String bname;

	@Column(name = "author")
	@NotEmpty(message = "Author is Required")
	@Size(min = 3, max = 10, message = "Name length must be between 3 and 10")
	private String author;

	@Column(name = "price")
	@NotNull(message = "Price is Required")
	@Min(value = 500, message = "Price must be min : 500")
	@Max(value = 1500, message = "Price must be max : 1500")
	private BigDecimal price;

	@Column(name = "category")
	@NotEmpty(message = "Category is Required")
	private String category;

	@Column(name = "pub")
	@NotEmpty(message = "Pub is Required")
	private String pub;

	public Book() {

	}

	@Override
	public String toString() {
		return "[" + bid + " , " + bname + " , " + author + " , " + price + " , " + category + " , " + pub + "]";
	}

	public Book(Integer bid,
			@NotEmpty(message = "Book Name is Required") @Size(min = 5, max = 20, message = "Name length must be between 5 and 20") String bname,
			@NotEmpty(message = "Author is Required") @Size(min = 3, max = 10, message = "Name length must be between 3 and 10") String author,
			@NotNull(message = "Price is Required") @Min(value = 500, message = "Price must be min : 500") @Max(value = 1500, message = "Price must be max : 1500") BigDecimal price,
			@NotEmpty(message = "Category is Required") String category,
			@NotEmpty(message = "Pub is Required") String pub) {
		
		this.bid = bid;
		this.bname = bname;
		this.author = author;
		this.price = price;
		this.category = category;
		this.pub = pub;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPub() {
		return pub;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}
}