package org.zhang.Test;

/**
 * @author: zhanghao
 * @date: 2021/11/22-19:22
 */

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhang.service.BookService;

/**
 * @Description
 */
public class BookServiceTest {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.service();
    }
}
