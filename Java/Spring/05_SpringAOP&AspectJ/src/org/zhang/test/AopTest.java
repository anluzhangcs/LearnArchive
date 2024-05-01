package org.zhang.test;

/**
 * @author: zhanghao
 * @date: 2021/11/25-16:16
 */

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhang.anno.Book;
import org.zhang.config.SpringConfig;
import org.zhang.xml.User;

/**
 * @Description
 */
public class AopTest {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Book book = context.getBean("book", Book.class);
        book.show();
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring2.xml");
        User user = context.getBean("user", User.class);
        user.login();
    }

    @Test
    public void test3() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Book book = context.getBean("book", Book.class);
        book.show();
    }

}
