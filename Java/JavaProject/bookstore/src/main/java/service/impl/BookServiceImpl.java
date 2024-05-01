package service.impl;

/**
 * @author: zhanghao
 * @date: 2021/11/3-17:56
 */

import bean.Book;
import bean.Page;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import org.apache.commons.beanutils.BeanUtils;

import java.util.List;

/**
 * @Description
 */
public class BookServiceImpl implements service.BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.deleteBook(id);
    }

    @Override
    public Book queryOne(Integer id) {
        return bookDao.queryForOne(id);
    }

    @Override
    public List<Book> queryList() {
        return bookDao.queryForList();
    }

    @Override
    public Integer queryCount() {
        return bookDao.queryCount();
    }

    @Override
    public List<Book> queryItems(Integer begin, Integer pageSize) {
        return bookDao.queryItems(begin, pageSize);
    }

    @Override
    public Page<Book> getPageByPrice(Integer pageNumber, Integer pageSize, Integer min, Integer max) {
        Page<Book> page = new Page<>();

        page.setPageSize(pageSize);
        Integer itemCount = bookDao.queryCountByPrice(min, max);
        page.setItemCount(itemCount);
        int pageTotal = itemCount % pageSize > 0 ? itemCount / pageSize + 1 : itemCount / pageSize;
        page.setPageTotal(pageTotal);
        page.setPageNumber(pageNumber);

        pageNumber = page.getPageNumber();

        int begin = (pageNumber-1)*pageSize;
        List<Book> items = bookDao.queryListByPrice(min, max,begin,pageSize);
        page.setItems(items);

        return page;
    }
}
