package demo1.java;

/**
 * @author: zhanghao
 * @date: 2021/9/11-9:25
 */

/**
 * @Description
 */
public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt){
        this.balance += amt;
        System.out.println("成功存入："+amt);
    }
    public void withdraw(double amt){
        if (this.balance>=amt){
            this.balance -= amt;
            System.out.println("成功取出："+amt);
        } else{
            System.out.println("您的余额不足");
        }
    }
}
