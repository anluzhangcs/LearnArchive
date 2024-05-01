package org.zhang.service;

/**
 * @author: zhanghao
 * @date: 2021/11/22-19:21
 */

import org.zhang.dao.BookDao;
import org.zhang.dao.impl.BookDaoImpl;

/**
 * @Description
 */
public class BookService {

    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void service() {
        System.out.println("业务层被调用");
        bookDao.execute();
    }
}
