package demo;

/**
 * @author: zhanghao
 * @date: 2021/9/21-19:42
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description 方式3:通过实现Callable接口
 *  ①创建实现Callable接口的实现类
 *  ②在实现类中重写call()方法
 *  ③创建实现类对象
 *  ④将实现类作为参数创建FutureTask对象,Callable接口实现类
 *  ⑤将FutureTask对象作为参数创建新线程,并调用start()方法,因为FutureTask实现了Runnable
 *
 *  优势:
 *    1. call()可以有返回值的。
 *    2. call()可以抛出异常，被外面的操作捕获，获取异常的信息
 *    3. Callable是支持泛型的
 *  局限:需要借助FutureTask类,FutureTask对象可以获取
 */
public class ThreadCreate3 {
    public static void main(String[] args) {
        ThreadImpCall call = new ThreadImpCall();
        FutureTask futureTask = new FutureTask(call);
        new Thread(futureTask).start();
        try {
            //get()方法返回值FutureTask对象构造器参数Callable实现类重写的call()的返回值
            Object o = futureTask.get();
            Integer sum = (Integer)o;
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class ThreadImpCall implements Callable {
    @Override
    public Object call() throws Exception{
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
                sum+=i;
            }
        }
        return sum;
    }
}
