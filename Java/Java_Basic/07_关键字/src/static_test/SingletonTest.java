package static_test;

/**
 * @author: zhanghao
 * @date: 2021/9/13-11:05
 */

/**
 * @Description 测试单例设计模式
 */
public class SingletonTest {
    public static void main(String[] args) {
        Order order1 = Order.getInstance();
        Order order2 = Order.getInstance();
        System.out.println(order1 == order2);

        Customer customer1 = Customer.getInstance();
        Customer customer2 = Customer.getInstance();
        System.out.println(customer1 == customer2);
    }
}
