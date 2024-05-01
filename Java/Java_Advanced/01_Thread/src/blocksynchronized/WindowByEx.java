package blocksynchronized;

/**
 * @author: zhanghao
 * @date: 2021/9/20-19:19
 */

/**
 * @Description 通过继承实现的多线程安全问题
 *
 *  方式1:同步代码块
 *      synchronized(obj){
 *          //操作共享数据的代码块
 *      }
 *      注:
 *          大致和通过实现Runnable接口相同,差异在obj上
 *          obj如果为类中的其它类对象,则需要声明为静态
 *          obj要慎用this关键字,多个线程就会有多个当前对象,不唯一
 *          obj可以用WindowByEx.class
 *
 */
public class WindowByEx extends Thread{
    private static int ticket=100;
    //obj为静态
    private static Object obj = new Object();
    @Override
    public void run() {
        while (true){
            //错误
//            synchronized (this){
            //正确
            synchronized (WindowByEx.class){
//            synchronized (obj){

                if (ticket>0){
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName()+"卖票:余票为"+ticket);
                    ticket--;
                } else{
                    break;
                }
            }
        }
    }
}
