package demo;

/**
 * @author: zhanghao
 * @date: 2021/9/15-22:02
 */

/**
 * @Description 实现接口
 *  -类中必须实现接口中所有的抽象类，否则还必须是一个抽象类
 *
 */
public class Plane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Plane fly by its engine!!!");
    }

    @Override
    public void stop() {
        System.out.println("Plane stop by its engine");
    }
}

interface AA{
    void method1();
}

interface BB{
    void method2();
}

interface CC extends AA,BB{
}