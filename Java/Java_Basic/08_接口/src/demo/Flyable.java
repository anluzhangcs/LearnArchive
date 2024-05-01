package demo;

/**
 * @author: zhanghao
 * @date: 2021/9/15-21:46
 */

/**
 * @Description 接口 Interface
 *  -Java中接口和类是并列的
 *  -接口就是定义的一组规则，表示能不能；而继承表示的是不是
 *  -接口可以多重实现，解决了类不能多重继承所带来的不方便的地方
 *  -接口不能实例化
 *
 *  定义：
 *      JDK7及以前：接口中只能定义全局常量和抽象方法
 *          全局常量：public static final ...
 *          抽象方法：public abstract ...(...);
 *      JDK8及以后：接口中除了全局变量和抽象方法外，还可以定义静态方法，默认方法（略）
 *  小知识：虽然大部分人用的JDK8，但Java使用上用的大部分还是JDK7中定义的
 *
 *  使用：通过class实现interface使用
 */
public interface Flyable {
    public static final int MAX_SPEED = 99;
    // public static final可以省略，因为接口中都是这样
    int MIN_SPEED = 11;

    public abstract void fly();
    //public abstract 也可以省略，接口中方法都有这个修饰
    void stop();
}
