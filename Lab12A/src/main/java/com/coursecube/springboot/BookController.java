package com.coursecube.springboot;

import java.math.BigDecimal;
import java.util.*;
import javax.servlet.ServletException;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("myBooksList")
public class BookController {

	Logger log = LoggerFactory.getLogger(BookController.class);
	private List<Book> bookList = new ArrayList<>();

	public BookController() {
		Book book1 = new Book(101, "Master Spring", "Srinivas", new BigDecimal(500), "JLC");
		Book book2 = new Book(102, "Master Angular", "Srinivas", new BigDecimal(600), "JLC");
		Book book3 = new Book(103, "Master Spring Boot", "Srinivas", new BigDecimal(700), "JLC");
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
	}

	@ModelAttribute(name = "mybook")
	public Book createBook() {
		Book book = new Book();
		return book;

	}

	@GetMapping("/")
	private String showIndexPage() throws ServletException {
		log.info("-------showIndexPage------------");

		return "index";
	}

	@GetMapping("/showbooks")
	public String showMyBooks(Model model) throws ServletException {

		log.info("------showMyBooks()------------");
		model.addAttribute("myBooksList", bookList);

		return "booksList";
	}

	@PostMapping("/addBook")
	private String addMyBook(@Valid @ModelAttribute("myBook") Book book, BindingResult result, Model model) {

		log.info("----------------addMyBook----------------");
		if (!result.hasErrors()) {

			book.setBid(bookList.size() + 101);
			bookList.add(book);
		}

		return "booksList";
	}
}
