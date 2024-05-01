package demo;

/**
 * @author: zhanghao
 * @date: 2021/9/20-18:58
 */

/**
 * @Description 创建线程方式二:通过实现Runnable接口
 *  ①创建实现Runnable接口的类
 *  ②实现接口中的抽象方法run();
 *  ③创建实现类对象
 *  ④将实现类对象作为参数构造Thread对象 public Thread(Runnable target)
 *  ⑤Thread对象就是一个线程,调用start()启动线程,执行run()方法
 *
 *  run()方法的调用问题:
 *  run()是Runnable()接口中的抽象方法
 *  继承Thread类:Thread实现Runnable接口有了run()方法,
 *              而子类重写了run()方法,所以子类start()时调用了重写的run()方法
 *  实现Runnable接口:在构造Thread(Runnable target)时,将实现类传给target,通过多态
 *              调用实现类中的run();
 */
public class ThreadCreate2 {
    public static void main(String[] args) {
        ThreadByImp threadByImp = new ThreadByImp();
        Thread t1 = new Thread(threadByImp);
        t1.setName("新线程1");
        t1.start();
    }

}

class ThreadByImp implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
