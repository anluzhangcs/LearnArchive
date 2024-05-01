package org.zhang.Test;

/**
 * @author: zhanghao
 * @date: 2021/11/22-17:50
 */

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhang.bean.Student;

/**
 * @Description
 */
public class StudentTest {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }
}
