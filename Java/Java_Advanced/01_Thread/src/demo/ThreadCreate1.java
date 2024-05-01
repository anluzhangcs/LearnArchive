package demo;

/**
 * @author: zhanghao
 * @date: 2021/9/20-11:08
 */

/**
 * @Description 创建Thread
 *   方式1:
 *      ①创建继承Thread的子类
 *      ②在子类中重写run()方法,方法中为新线程要执行的任务
 *      ③在main方法(主线程)中创建子类对象并调用start();
 */
public class ThreadCreate1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        /*
         * start()方法
         * -只能被当前对象调用一次
         * -完成功能:①线程的启动;②run()方法的调用
         * -注:不能直接调用run()方法,此时新线程没有启动,还是在主线程下执行
         */
        myThread.start();
        //不能达到新线程执行的目的
//        myThread.run();

        for (int i = 0; i < 100; i++) {
            if (i%2 != 0){
                System.out.println(i+"*****主线程*****");
            }
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0){
                System.out.println(i+"******新线程*******");
            }
        }
    }
}