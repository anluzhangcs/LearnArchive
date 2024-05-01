package org.zhang.Test;

/**
 * @author: zhanghao
 * @date: 2021/11/22-17:56
 */

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhang.bean.Order;

import java.util.Date;

/**
 * @Description
 */
public class OrderTest {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Order order = context.getBean("order", Order.class);
        System.out.println(order);

    }

    @Test
    public void test2() {
        System.out.println(new Date().getTime());
    }
}
