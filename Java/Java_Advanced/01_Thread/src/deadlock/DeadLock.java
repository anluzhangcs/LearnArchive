package deadlock;

/**
 * @author: zhanghao
 * @date: 2021/9/21-15:13
 */

/**
 * @Description 死锁
 *  产生原因:锁得不到释放,a线程需要b线程的锁才能动,b线程需要a线程的锁才能动,从而造成谁也动不了
 *          全部处于阻塞状态
 */
public class DeadLock {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        //通过继承实现新线程的创建
        new Thread(){
            @Override
            public void run() {
                synchronized (s1){
                    s1.append('i');
                    s2.append(1);
                    //sleep(),使得下面线程启动,增加死锁概率
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2){
                        s1.append('b');
                        s2.append(2);
                    }
                }
                System.out.println(s1);
                System.out.println(s2);
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2){
                    s1.append('i');
                    s2.append(1);

                    synchronized (s1){
                        s1.append('b');
                        s2.append(2);
                    }
                }
                System.out.println(s1);
                System.out.println(s2);
            }
        }).start();
    }
}
