package blocksynchronized;

/**
 * @author: zhanghao
 * @date: 2021/9/20-19:29
 */

/**
 * @Description 实现Runnable接口的多线程安全问题
 *  引入:以售票为例,会出现重票,票号为负问题
 *  原因:当进程中有共享数据时,一个线程进入操作,但还没有完成时,其它线程进入,就是造成线程安全问题
 *  解决方案:就像上厕所一样,坑位是共享的,我们要解决冲突问题,就需要上锁.
 *          这样进入一个进程后,其他进程不能进来,这样就能解决上述问题.
 *
 *  方式一:同步代码块
 *      synchronized(obj){
 *          //操作共享数据的代码块
 *      }
 *      注: synchronized是关键字
 *          obj为同步监听器,就是锁.可以为任意对象,但是所有线程必须用同一个锁
 *          obj也可以用this代替,因为WindowByImp只会创建一次
 *          obj也可以用WindowByImp.class代替,因为类也是对象,且只会加载一次
 *          代码块不能多也不能少,少了线程安全没有解决,多了降低速度,还会出现错误,如多线程变单线程
 */
public class WindowByImp implements Runnable {
    private int ticket=100;
    private Object obj = new Object();
    @Override
    public void run() {
        while (true){
//            synchronized(this){
            synchronized(WindowByImp.class){
//            synchronized(obj){

                if (ticket>0){
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"卖票:余票为"+ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
