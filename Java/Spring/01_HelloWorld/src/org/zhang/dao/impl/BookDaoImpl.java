package org.zhang.dao.impl;

/**
 * @author: zhanghao
 * @date: 2021/11/22-19:19
 */

import org.zhang.dao.BookDao;


/**
 * @Description
 */
public class BookDaoImpl implements BookDao {


    @Override
    public void execute() {
        System.out.println("BookDaoImpl 被注入了");
    }
}
