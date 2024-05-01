package methodsynchronized;

/**
 * @author: zhanghao
 * @date: 2021/9/21-10:29
 */

/**
 * @Description 使用synchronized解决单例懒汉模式的线程不安全问题
 *
 * 若run()方法中调用getInstance就是出现可能创建多个bank对象
 *
 * 解决方式:
 *      1.将getInstance()使用synchronized修饰
 *          局限性:效率低,bank不为空后,其它线程依旧要等待判断
 *      2.提高1的效率
 */
public class BankTest {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(bank1 == bank2);
    }
}

class Bank{
    //1.私有化构造方法
    private Bank(){

    }

    //2.声明静态当前类对象并赋值为null
    private static Bank bank = null;

    //3.创建获取对象方法
//    public synchronized static Bank getInstance(){
//        if (bank == null){
//            bank = new Bank();
//        }
//        return bank;
//    }
    public static Bank getInstance(){
        //若bank不为空,则其他线程不需要等待
        if (bank == null){
            synchronized (Bank.class){

                if (bank == null){
                    bank = new Bank();
                }
            }
        }

        return bank;
    }

}
