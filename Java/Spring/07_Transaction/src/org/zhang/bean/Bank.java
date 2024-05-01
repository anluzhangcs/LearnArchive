package org.zhang.bean;

/**
 * @author: zhanghao
 * @date: 2021/11/30-15:32
 */

/**
 * @Description javabean
 */
public class Bank {
    private int id;
    private double balance;

    public Bank() {
    }

    public Bank(int id, double balance) {
        this.id = id;
        this.balance = balance;
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

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
