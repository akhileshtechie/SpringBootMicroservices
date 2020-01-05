package com.coursecube.spring.daoimpl;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
* @Author : Akhilesh Bhagat
* @company : Java Learning Center
* */
import com.coursecube.spring.dao.BookDAO;
import com.coursecube.spring.entity.Book;
@Repository
@Transactional
public class BookDAOImpl implements BookDAO{
@Autowired
EntityManager entityManager;
public List<Book> getAllBooks(){
System.out.println("-----BookDAOImpl--getAllBooks()---------");
String jpaql = "from Book book";
List<Book> list=entityManager.createQuery(jpaql) .getResultList();
return list;
}
@Override
public List<Book> getAllBooks(int start, int total) {
System.out.println("-----BookDAOImpl--getAllBooks(start,total)---------"); 
String jpaql = "from Book book";
List<Book> list=entityManager.createQuery(jpaql)
.setFirstResult(start)
.setMaxResults(total)
.getResultList();
return list;
}
public Book getBookById(Integer bid) {
System.out.println("-----BookDAOImpl--getBookById()---------");
return entityManager.getReference(Book.class,bid);
}
public void addBook(Book book) {
System.out.println("-----BookDAOImpl--addBook()---------");
entityManager.persist(book);
}
public void deleteBook(Integer bid) {
System.out.println("-----BookDAOImpl--deleteBook()---------");
Book book=entityManager.getReference(Book.class,bid);
entityManager.remove(book);
}
public int getBookCount() {
System.out.println("-----BookDAOImpl--getBookCount()---------");
String sql="select count(*) from mybooks";
BigInteger big=(BigInteger)entityManager.createNativeQuery(sql).getSingleResult();
return    (Integer) entityManager.createNativeQuery(sql).getSingleResult();// big.longValue();
}
public void updateBook(Book book) {
System.out.println("-----BookDAOImpl--updateBook()---------");
entityManager.merge(book);
}
} 