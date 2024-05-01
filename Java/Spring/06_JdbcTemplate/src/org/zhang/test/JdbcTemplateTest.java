package org.zhang.test;

/**
 * @author: zhanghao
 * @date: 2021/11/30-12:55
 */

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhang.bean.User;
import org.zhang.service.UserService;
import sun.rmi.server.UnicastServerRef;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 */
public class JdbcTemplateTest {


    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean("userService", UserService.class);

        userService.addUser(new User(null, "zhangsan", "123456", "zhangsan@qq.com"));
    }


    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean("userService", UserService.class);

        userService.updateUser(new User(2, "zhangsan", "123456", "zhangsan@qq.com"));
    }


    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean("userService", UserService.class);

        userService.deleteUser(2);
    }


    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean("userService", UserService.class);

        System.out.println(userService.getCount());
    }


    @Test
    public void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean("userService", UserService.class);

        System.out.println(userService.getUser(1));
    }


    @Test
    public void test6() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean("userService", UserService.class);

        System.out.println(userService.getAllUsers());
    }


    @Test
    public void test7() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean("userService", UserService.class);

        List<User> users = new ArrayList<>();
        users.add(new User(null, "lisi", "123456", "lisi@qq.com"));
        users.add(new User(null, "wangwu", "123456", "wangwu@qq.com"));
        users.add(new User(null, "zhangsan", "123456", "zhangsan@qq.com"));
        users.add(new User(null, "xiaohao", "123456", "xiaohao@qq.com"));
        userService.addBatch(users);
    }


    @Test
    public void test8() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean("userService", UserService.class);

        List<User> users = new ArrayList<>();
        users.add(new User(3, "lisi", "abcde", "lisi@qq.com"));
        users.add(new User(4, "wangwu", "abcde", "wangwu@qq.com"));
        users.add(new User(5, "zhangsan", "abcde", "zhangsan@qq.com"));
        users.add(new User(6, "xiaohao", "abcde", "xiaohao@qq.com"));
        userService.updateBatch(users);
    }



}
