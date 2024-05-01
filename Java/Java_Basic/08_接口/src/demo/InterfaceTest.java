package demo;

/**
 * @author: zhanghao
 * @date: 2021/9/15-21:44
 */

/**
 * @Description 接口测试
 */
public class InterfaceTest {
    public static void main(String[] args) {

        //接口也可以实现多态
        Flyable fly = new Bird();
        fly.fly();
        fly.stop();
        System.out.println("*****************************");
        fly = new Plane();
        fly.fly();
        fly.stop();
    }
}
