package communication;

/**
 * @author: zhanghao
 * @date: 2021/9/21-16:42
 */

/**
 * @Description 线程通信之交替打印1-100自然数
 *  wait(long mils):使当前线程堵塞,释放CPU的执行权 <==>相反sleep()并不会释放执行权
 *  notify():唤醒wait()进入堵塞的线程,若有多条,则根据优先级来唤醒
 *  notifyAll():唤醒所有wait()进入堵塞的线程
 *
 *  注意点:
 *      -wait(),notify(),notifyAll()只在synchronized中使用,Lock中用其他方法
 *      -调用wait(),notify(),notifyAll()的是同步监视器
 *      -因为同步监视器可以是任意对象,所以wait(),notify(),notifyAll()在Object方法中
 *
 *  sleep()和wait()的异同
 *  同:都可以使线程进入堵塞状态
 *  异:①声明位置不同.wait在Object中,sleep在Thread中
 *     ②wait只能在synchronized中被同步监视器调用,sleep可以在任意位置通过Thread调用
 *     ③wait会释放CPU执行权,而sleep不会
 */
public class Test1 {
    public static void main(String[] args) {
        Window window = new Window();
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}

class Window implements Runnable{
    private int i = 1;
    @Override
    public void run() {
        while (true) {
            synchronized (this) { //同步监视器:this当前对象
                //有线程进入后锁上,并唤醒另一个线程,避免两个线程同时wait()进入堵塞状态
                notify();
                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                } else {
                    break;
                }
                //打印完成后wait()进入堵塞,保证下一次是另一个线程进来
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}