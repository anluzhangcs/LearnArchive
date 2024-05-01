package org.zhang.test;

/**
 * @author: zhanghao
 * @date: 2021/11/30-19:29
 */

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhang.config.SpringConfig;
import org.zhang.service.BankService;

/**
 * @Description
 */
public class TransactionTest {


    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        BankService bankService = context.getBean("bankService", BankService.class);
        bankService.transferAccount(1, 2, 100);
    }


    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring2.xml");
        BankService bankService = context.getBean("bankService", BankService.class);
        bankService.transferAccount(1, 2, 100);
    }


    @Test
    public void test3() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BankService bankService = context.getBean("bankService", BankService.class);
        bankService.transferAccount(1, 2, 100);
    }



}
