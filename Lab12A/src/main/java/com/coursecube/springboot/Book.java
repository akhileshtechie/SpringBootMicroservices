package com.coursecube.springboot;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Book {

	private Integer bid;

	@NotEmpty(message = "Book Name is Required")
	@Size(min = 5, max = 20, message = "Name length must be between 5 and 20")
	private String bname;
	@NotEmpty(message = "Author is Required")
	@Size(min = 3, max = 10, message = "Name length must be between 3 and 20")
	private String author;
	@NotNull(message = "Price is required")
	@Min(value = 500, message = "Price must be min : 500")
	@Max(value = 1500, message = "Price must be max : 1500")
	private BigDecimal price;

	@NotEmpty(message = "Pub is Required")
	private String pub;

	public Book(Integer bid,
			@NotEmpty(message = "Book Name is Required") @Size(min = 5, max = 20, message = "Name length must be between 5 and 20") String bname,
			@NotEmpty(message = "Author is Required") @Size(min = 3, max = 10, message = "Name length must be between 3 and 20") String author,
			@NotNull(message = "Price is required") @Min(value = 500, message = "Price must be min : 500") @Max(value = 1500, message = "Price must be max : 1500") BigDecimal price,
			@NotEmpty(message = "Pub is Required") String pub) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.author = author;
		this.price = price;
		this.pub = pub;
	}

	public Book(
			@NotEmpty(message = "Book Name is Required") @Size(min = 5, max = 20, message = "Name length must be between 5 and 20") String bname,
			@NotEmpty(message = "Author is Required") @Size(min = 3, max = 10, message = "Name length must be between 3 and 20") String author,
			@NotNull(message = "Price is required") @Min(value = 500, message = "Price must be min : 500") @Max(value = 1500, message = "Price must be max : 1500") BigDecimal price,
			@NotEmpty(message = "Pub is Required") String pub) {
		super();
		this.bname = bname;
		this.author = author;
		this.price = price;
		this.pub = pub;
	}

	public Book() {
		
	}

}
