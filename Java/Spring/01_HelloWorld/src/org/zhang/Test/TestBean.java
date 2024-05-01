package org.zhang.Test;

/**
 * @author: zhanghao
 * @date: 2021/11/22-20:24
 */

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhang.bean.Employee;

/**
 * @Description
 */
public class TestBean {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee);
    }


    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee);
    }

}
