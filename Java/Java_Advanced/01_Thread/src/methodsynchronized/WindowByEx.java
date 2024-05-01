package methodsynchronized;

/**
 * @author: zhanghao
 * @date: 2021/9/20-19:19
 */

/**
 * @Description 通过继承实现的多线程安全问题
 *
 *  方式2:同步方法
 *   -对操作共享数据的方法加上synchronized关键字
 *   -synchronized一般不加在run()方法上,会造成只有一个线程
 *   -同步方法还是有同步监听器,只是默认,不需要显式声明
 *      非静态方法:obj为this
 *      静态方法:obj为当前类,继承Thread一般使用
 *
 */
public class WindowByEx extends Thread{
    private static int ticket=100;
    @Override
    public void run() {
        while (true){
            show();
        }
    }

    private synchronized static void show(){
        if (ticket>0){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"卖票:余票为"+ticket);
            ticket--;
        }
    }
}
