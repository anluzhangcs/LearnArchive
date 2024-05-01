package java8;

/**
 * @author: zhanghao
 * @date: 2021/9/17-19:45
 */

/**
 * @Description interface Java8新特性
 * 除了全局常量和抽象方法外，还可以定义默认方法和静态方法,且public可以省略
 */
public interface Filial {
    public default void help(){
        System.out.println("救我，儿子");
    }

    public static void destiny(){
        System.out.println("我是妈妈");
    }
}
