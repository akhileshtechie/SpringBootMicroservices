package com.coursecube.spring.service;
import java.util.List;

import com.coursecube.spring.entity.Book;


/*
* @Author : Akhilesh Bhagat
* @company : Java Learning Center
* */
public interface BookService {
 public List<Book> getAllBooks();
 public List<Book> getAllBooks(int start,int total);
 public Book getBookById(Integer bid);
 public void addBook(Book book);
 public void updateBook(Book book);
 public void deleteBook(Integer bid);
 public int getBookCount();
}