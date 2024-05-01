package deadlock;

/**
 * @author: zhanghao
 * @date: 2021/9/21-15:51
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description Lock锁,解决线程安全问题2  ---JDK5.0之后
 *  -Lock为接口,常用实现类为ReentrantLock
 *  -Lock只用于代码块,不用于方法
 *  -Lock需显示声明锁和解锁(注意最后一定要解锁,否则会单线程执行)
 *
 *  1.解决线程安全的方式
 *      synchronized(同步方法,同步代码块)和Lock
 *
 *  2.synchronized和Lock的异同
 *  异:  Lock只用于代码块,不用于方法
 *  *    Lock需显示声明锁和解锁(注意最后一定要解锁,否则会单线程执行)
 */
public class LockTest {
    public static void main(String[] args) {
        Window window = new Window();
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}


class Window implements Runnable{
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                if (ticket > 0 ){
                    System.out.println(Thread.currentThread().getName()+"-卖票,余票为:"+ticket);
                    ticket--;
                } else{
                    break;
                }
            } finally {
                lock.unlock();
            }

        }
    }
}