package methodsynchronized;

/**
 * @author: zhanghao
 * @date: 2021/9/20-19:17
 */

/**
 * @Description 卖票
 */
public class SaleTicket {
    public static void main(String[] args) {
//        WindowByEx window1 = new WindowByEx();
//        WindowByEx window2 = new WindowByEx();
//        WindowByEx window3 = new WindowByEx();
//        window1.setName("窗口1");
//        window2.setName("窗口2");
//        window3.setName("窗口3");
//        window1.start();
//        window2.start();
//        window3.start();

        WindowByImp windowByImp = new WindowByImp();
        Thread t1 = new Thread(windowByImp);
        Thread t2 = new Thread(windowByImp);
        Thread t3 = new Thread(windowByImp);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
