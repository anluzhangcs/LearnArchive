package demo;

/**
 * @author: zhanghao
 * @date: 2021/9/20-12:51
 */

/**
 * @Description Thread常用方法
 *  start();    启动当前线程并执行run()方法
 *  run();      执行run()方法类的操作
 *  CurrentThread(); static 获取当前线程
 *  getName();  获取当前线程名
 *  setName();  设置当前线程名,要在start()方法前执行
 *  yield();    CPU将当前线程释放,并决定下个线程
 *  join()      调用该方法线程后,CPU一直执行直到当前线程结束后执行其它线程
 *  sleep(mil); 调用该方法线程休息mil毫秒后执行
 *  isAlive();  判断线程是否还活着
 *
 *  线程调度:优先级
 *  MAX_PRIORITY 10
 *  MIN_PRIORITY 1
 *  NORM_PRIORITY 5
 *  设置优先级:setPriority();
 *  获取优先级:getPriority();
 *  注:低优先级并不代表一定会在高优先级执行完后执行,只是CPU分配给它的概率低
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        ThreadMethod t1 = new ThreadMethod("Thread1===");
        System.out.println(t1.getName());
        t1.setName("Thread2====");
        t1.setPriority(3);
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setName("主线程");
        t1.start();

        for (int i = 0; i < 100; i++) {
            if (i%2 != 0){
                System.out.println(Thread.currentThread().getName()+":"+i+","+Thread.currentThread().getPriority());
            }
            if (i == 20){
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(t1.isAlive());
    }
}

class ThreadMethod extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0){
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName()+":"+i+","+getPriority());
            }

            if (i==20){
//                yield();
            }
        }
    }

    public ThreadMethod() {
    }

    public ThreadMethod(String name) {
        super(name);
    }
}
