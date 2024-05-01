package demo1.test;

/**
 * @author: zhanghao
 * @date: 2021/9/11-9:37
 */

import demo1.java.Account;
import demo1.java.Bank;

/**
 * @Description
 */
public class BankTest {
    public static_test void main(String[] args) {
        Bank bank = new Bank();
        bank.addCustomer("zhang","hao");
        Account account = new Account(1000);
        bank.getCustomer(0).setAccount(account);
        System.out.println(bank.getCustomer(0));
        bank.addCustomer("li","si");
        bank.addCustomer("wang","wu");
        System.out.println(bank.getNumberOfCustomer());
    }
}
