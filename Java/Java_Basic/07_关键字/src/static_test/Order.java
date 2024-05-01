package static_test;

/**
 * @author: zhanghao
 * @date: 2021/9/13-11:00
 */

/**
 * @Description static关键字的应用
 *单例设计模式:从始至终创建一个对象
 * 饿汉式：
 *      缺点：对象的生命周期过长
 *      优点：天然线程安全
 *
 */
public class Order {
    //1.私有化构造器，在类外不能调用构造器创建对象
    private Order(){

    }
    //2.在类内部创建对象,也相当于成员，一般为私有，static方便静态方法调用
    private static Order order = new Order();

    //创建静态方法，使得不用创建对象直接通过类来获取实例化对象
    public static Order getInstance(){
        return order;
    }
}
