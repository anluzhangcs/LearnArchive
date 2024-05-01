package demo1.test;

/**
 * @author: zhanghao
 * @date: 2021/9/10-22:26
 */

import demo1.java.Account;
import demo1.java.Customer;

/**
 * @Description
 */
public class TestExer1 {
    public static_test void main(String[] args) {
        Account account = new Account(1000, 2000, 0.0123);
        Customer customer = new Customer("Jane", "Smith");
        customer.setAccount(account);
        customer.getAccount().deposit(100);
        customer.getAccount().withDraw(960);
        customer.getAccount().withDraw(2000);
        System.out.println(customer);
    }
}
