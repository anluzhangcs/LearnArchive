package org.zhang.Test;

/**
 * @author: zhanghao
 * @date: 2021/11/22-15:54
 */

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhang.bean.User;

/**
 * @Description 测试使用Spring框架来创建类的实例
 */
public class UserTest {
    @Test
    public void test1() {

        //1.读取bean.xml Spring配置文件.因为bean.xml在类路径下,所以可以用ClassPathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //2.创建User对象.
        //第一个参数为在配置文件中bean标签的id
        //第二个参数为对应id的类的Class实例.如果不写,默认返回Object类型,但实际上还是User
//        User user = (User) context.getBean("user");
        User user = context.getBean("user",User.class);
        System.out.println(user);
        user.show();

    }

    @Test
    public void test2() {

        /*
         * BeanFactory接口 -- 实现Spring IOC容器方式之一
         *  特点:
         *      ①BeanFactory是Spring框架内部使用的,一般不对外提供使用
         *      ②BeanFactory读取配置文件时不会创建对象.等需要时才创建
         */

        BeanFactory factory = new ClassPathXmlApplicationContext("bean.xml");
        User user = factory.getBean("user", User.class);
        System.out.println(user);
        user.show();
    }

    @Test
    public void test3() {
        /*
         * ApplicationContext接口 --实现Spring IOC容器方式之二
         *  特点:
         *      ①它是BeanFactory的子接口
         *      ②ApplicationContext一般提供给外部(即开发人员)使用
         *      ③ApplicationContext读取配置文件时会创建所有配置的Bean对象
         *
         *  常用实现类:
         *      ClassPathXmlApplicationContext用于加载类路径下的配置文件
         *      FileSystemXmlApplicationContext用于加载盘符下绝对路径的配置文件
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.show();
    }
}
