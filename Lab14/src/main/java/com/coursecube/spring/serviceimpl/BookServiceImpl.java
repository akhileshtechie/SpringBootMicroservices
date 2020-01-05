package com.coursecube.spring.serviceimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coursecube.spring.dao.BookDAO;
import com.coursecube.spring.entity.Book;
import com.coursecube.spring.service.*;
@Service
public class BookServiceImpl implements BookService{
@Autowired
BookDAO bookDAO;
@Autowired
MailService mailService;
@Override
public List<Book> getAllBooks() {
System.out.println("-----BookServiceImpl--getAllBooks()---------");
return bookDAO.getAllBooks();
}
@Override
public List<Book> getAllBooks(int start, int total) {
System.out.println("-----BookServiceImpl--getAllBooks(start,total)---------");
return bookDAO.getAllBooks(start,total);
} 
@Override
public Book getBookById(Integer bid) {
System.out.println("-----BookServiceImpl--getBookById()---------");
return bookDAO.getBookById(bid);
}
@Override
public void addBook(Book book) {
System.out.println("-----BookServiceImpl--addBook()---------");
bookDAO.addBook(book);
String from="<username>@gmail.com";
String to="<username>@gmail.com";
String subject="New Book @ JLC Book Store";
String body="<font color=red size=5> New Book : "+ book.getBname() +" <br/> By"+book.getAuthor()+" <br/> at Rs." +book.getPrice();
mailService.sendMail(from, to, subject, body);
}
@Override
public void updateBook(Book book) {
System.out.println("-----BookServiceImpl--updateBook()---------");
bookDAO.updateBook(book);
}
@Override
public void deleteBook(Integer bid) {
System.out.println("-----BookServiceImpl--deleteBook()---------");
bookDAO.deleteBook(bid);
}
public int getBookCount() {
return bookDAO.getBookCount();
}
} 