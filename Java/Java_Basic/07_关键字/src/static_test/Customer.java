package static_test;

/**
 * @author: zhanghao
 * @date: 2021/9/13-11:10
 */

/**
 * @Description 单例设计模式
 * 懒汉式：
 *      缺点：此写法线程不安全，后面会改进
 *      优点：延迟对象的创建
 */
public class Customer {
    //1.私有化构造器
    private Customer(){

    }

    //2.声明Customer对象，赋值为null
    private static Customer customer = null;

    //3.创建静态的返回对象方法
    public static Customer getInstance(){
        //判断对象是否为空，为空则创建对象，否则直接返回
        if (customer == null){
            customer = new Customer();
        }
        return customer;
    }
}
