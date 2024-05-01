package org.zhang.test;

/**
 * @author: zhanghao
 * @date: 2021/11/22-21:32
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhang.autowire.Employee;
import org.zhang.bean.Course;
import org.zhang.bean.Student;
import org.zhang.lifetime.Order;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description
 */
public class TestDemo {

    private Connection connection;

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Course course1 = context.getBean("course", Course.class);
        Course course2 = context.getBean("course", Course.class);
        System.out.println(course1 == course2); //true
    }

    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        System.out.println("第六步,获取到bean实例");
        Order order = context.getBean("order", Order.class);

        //销毁IOC容器
        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test
    public void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        Employee emp = context.getBean("emp", Employee.class);
        System.out.println(emp);
    }

    @Test
    public void test6() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean6.xml");
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
