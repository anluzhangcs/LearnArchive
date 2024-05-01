package communication;

/**
 * @author: zhanghao
 * @date: 2021/9/22-17:15
 */

/**
 * @Description 线程通信例题  ---生产者消费者问题
 *  生产者(Producer)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 *
 *  分析:
 *      是否线程安全:否,有共享数据Clerk,产品数
 *      是否线程通信:是
 */

class Clerk {
    //产品数量
    private int total=0;


    //生产商品
    public synchronized void produce() { //监视器:当前对象类
            if (total < 20) {
                total++;
                System.out.println(Thread.currentThread().getName() + ":生产第" + total+"个商品");
                notify();
            } else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
    }

    //消费商品
    public synchronized void comsume(){
            if (total > 0) {
                System.out.println(Thread.currentThread().getName() + ":消费第" + total+"个商品");
                total--;
                notify();
            } else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}

class Producer implements Runnable{

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }


    @Override
    public void run() {
        while (true) {
            clerk.produce();
        }
    }
}

class Customer implements Runnable{

    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //消费商品
        while (true) {

            clerk.comsume();
        }
    }
}

public class ProductAndCustomer {
    public static void main(String[] args) {
        //创建店员,并初始化商品数为0
        Clerk clerk = new Clerk();

        //创建Producer线程和Customer线程
        Thread p1 = new Thread(new Producer(clerk));
        Thread p2 = new Thread(new Producer(clerk));
        Thread c1 = new Thread(new Customer(clerk));

        //设置线程名称
        p1.setName("生产者1");
        p2.setName("生产者2");
        c1.setName("消费者1");

        //启动线程
        p1.start();
//        p2.start();
        c1.start();
    }
}
