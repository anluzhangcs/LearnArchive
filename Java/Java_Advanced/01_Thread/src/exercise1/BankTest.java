package exercise1;

/**
 * @author: zhanghao
 * @date: 2021/9/21-16:11
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 */
public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank(1000);
        Thread t1 = new Thread(bank);
        Thread t2 = new Thread(bank);
        t1.setName("储户1");
        t2.setName("储户2");
        t1.start();
        t2.start();
    }
}

class Bank implements Runnable{
    private double balance;
    private int tmp = 3;
    private ReentrantLock lock = new ReentrantLock();
    public Bank(double balance){
        this.balance = balance;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (tmp > 0) {
                    balance += 1000;
                    System.out.println("账户:"+Thread.currentThread().getName()+"您的当前余额为:" + balance);
                    tmp--;

                } else {
                    break;
                }
            } finally {

                lock.unlock();
            }
        }
    }

    //存钱
    private void deposite(double money){
        balance += money;
        System.out.println("您的当前余额为:"+balance);
    }
}