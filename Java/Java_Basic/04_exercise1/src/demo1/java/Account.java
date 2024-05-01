package demo1.java;

/**
 * @author: zhanghao
 * @date: 2021/9/10-22:25
 */

import java.text.NumberFormat;

/**
 * @Description
 */
public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public void withDraw(double account){
        if (this.balance>=account){
            this.balance -= account;
            System.out.println("成功取入："+account);
        } else{
            System.out.println("您的余额不足！！！");
        }
    }

    public void deposit(double account){
        this.balance += account;
        System.out.println("成功存入："+account);
    }

    @Override
    public String toString() {

        /**
         * 将小数转化为百分数
         * ① NumberFormat nt = NumberFormat.getPercentInstance();获取格式化对象
         * ② setMinimumFractionDigits( int num) 设置保留小数点后几位
         * ③ nt.format(...) 进行格式化
         */
        NumberFormat nt = NumberFormat.getPercentInstance();
        nt.setMinimumFractionDigits(2);
        return
                "id is" + id +
                ", balance is" + balance +
                ", annualInterestRate is" + nt.format(annualInterestRate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
}
