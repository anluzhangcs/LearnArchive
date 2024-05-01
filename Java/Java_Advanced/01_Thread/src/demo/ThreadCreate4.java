package demo;

/**
 * @author: zhanghao
 * @date: 2021/9/21-20:48
 */

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Description 方式4:使用线程池
 *  ①通过Executors工具类创建指定线程数的线程池并赋值给线程池接口ExecutorService
 *          Executors为工具类,是创建线程池的工厂
 *          ExecutorService真正的线程池接口
 *  ②通过方法执行具体的线程操作
 *       //excute()方法,适用于实现Runnable接口类
 *      //submit()方法,适用于实现Callable接口类
 *  ③关闭线程池 service.shutdown()
 *   好处：
 *   1.提高响应速度（减少了创建新线程的时间）
 *   2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 *   3.便于线程管理
 *
 *   设置线程池:通过线程池的具体类对象来实现 ThreadPoolExecutor
 *        corePoolSize：核心池的大小
 *        maximumPoolSize：最大线程数
 *        keepAliveTime：线程没有任务时最多保持多长时间后会终止
 */
public class ThreadCreate4 {
    public static void main(String[] args) {
        //创建指定线程数的线程池,Executors为工具类,是创建线程池的工厂
        ExecutorService service = Executors.newFixedThreadPool(10);
        System.out.println(service.getClass());

        //设置线程连接池,通过线程池的具体类对象来实现
        ThreadPoolExecutor realPool = (ThreadPoolExecutor)service;
        realPool.setCorePoolSize(10);
//        realPool.setKeepAliveTime();

        //excute()方法,适用于实现Runnable接口类
        service.execute(new NumberThread1());
        service.execute(new NumberThread2());
        //submit()方法,适用于实现Callable接口类
//        service.submit()

        service.shutdown();
    }
}

class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class NumberThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}