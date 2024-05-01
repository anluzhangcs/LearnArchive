package demo;

/**
 * @author: zhanghao
 * @date: 2021/9/15-22:05
 */

/**
 * @Description 实现接口
 */
public class Bird implements Flyable{
    @Override
    public void fly() {
        System.out.println("Bird fly by its wings");
    }

    @Override
    public void stop() {
        System.out.println("Bird stop by its foots");
    }
}
