package dao;

/**
 * @author: zhanghao
 * @date: 2021/11/3-17:14
 */

import bean.Book;

import java.util.List;

/**
 * @Description BookDao对数据库book表的操作
 */
public interface BookDao {

    int addBook(Book book);

    int deleteBook(Integer id);

    int updateBook(Book book);

    Book queryForOne(Integer id);

    List<Book> queryForList();

    int queryCount();

    List<Book> queryItems(Integer begin, Integer pageSize);

    Integer queryCountByPrice(Integer min, Integer max);

    List<Book> queryListByPrice(Integer min, Integer max, int begin, Integer pageSize);
}
