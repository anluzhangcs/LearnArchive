package methodsynchronized;

/**
 * @author: zhanghao
 * @date: 2021/9/20-19:29
 */

/**
 * @Description 实现Runnable接口的多线程安全问题
 *  方式2:同步方法
 *
 */
public class WindowByImp implements Runnable {
    private int ticket=100;
    @Override
    public void run() {
        while (true){
            show();
        }
    }

    private synchronized void show(){
        if (ticket>0){
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"卖票:余票为"+ticket);
            ticket--;
        }
    }
}
