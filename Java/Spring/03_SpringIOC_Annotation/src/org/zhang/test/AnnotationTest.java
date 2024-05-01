package org.zhang.test;

/**
 * @author: zhanghao
 * @date: 2021/11/24-10:21
 */

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhang.dao.UserDao;
import org.zhang.config.SpringConfig;
import org.zhang.dao.impl.UserDaoImpl;
import org.zhang.service.impl.UserServiceImpl;

/**
 * @Description
 */
public class AnnotationTest {
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        UserDao userDao = context.getBean("userdao", UserDaoImpl.class);
//        userDao.execute();
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserServiceImpl userService = context.getBean("userServiceImpl", UserServiceImpl.class);
        userService.login();
    }

    @Test
    public void test3() {
        //创建Spring IOC容器时使用AnnotationConfigApplicationContext注解配置这个实现类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserServiceImpl userService = context.getBean("userServiceImpl", UserServiceImpl.class);
        userService.login();
    }
}
