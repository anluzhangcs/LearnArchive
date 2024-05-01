package test;

import bean.Book;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;



/**
 * @author: zhanghao
 * @date: 2021/11/3-17:40
 */
public class BookDaoImplTest {

    BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "三体", "刘慈欣", new BigDecimal(56.4), 1000, 345, ""));
    }

    @Test
    public void deleteBook() {
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "三毛", "刘慈欣", new BigDecimal(56.4), 1000, 345, ""));
    }

    @Test
    public void queryForOne() {
        System.out.println(bookDao.queryForOne(21));
    }

    @Test
    public void queryForList() {
        List<Book> books = bookDao.queryForList();
        books.forEach(System.out::println);

    }

    @Test
    public void queryCount() {
        int count = bookDao.queryCount();
        System.out.println(count);
    }

    @Test
    public void queryItems() {
        bookDao.queryItems(0, 4).forEach(System.out::println);
    }

    @Test
    public void queryCountByPrice() {
        System.out.println(bookDao.queryCountByPrice(10,50));
    }

    @Test
    public void queryListByPrice() {
        bookDao.queryListByPrice(10, 50,0,4).forEach(System.out::println);
    }
}