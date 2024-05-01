package service;

/**
 * @author: zhanghao
 * @date: 2021/11/3-18:01
 */

import bean.Book;
import bean.Page;

import java.util.List;

/**
 * @Description
 */
public interface BookService {
    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(Integer id);

    Book queryOne(Integer id);

    List<Book> queryList();

    Integer queryCount();

    List<Book> queryItems(Integer begin, Integer pageSize);

    Page<Book> getPageByPrice(Integer pageNumber, Integer pageSize, Integer min, Integer max);
}
