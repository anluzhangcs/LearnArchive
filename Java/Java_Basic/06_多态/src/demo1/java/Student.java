package demo1.java;

/**
 * @author: zhanghao
 * @date: 2021/9/11-18:29
 */

/**
 * @Description 方法的重写
 * 权限修饰 返回值 方法名(形参列表) {方法体}
 *  -权限修饰必须大于原方法
 *  -返回值为void 或 基本数据类型，则必须和原方法一致
 *   返回值为对象，则重写方法返回值可以为原方法返回值的子类
 *  -方法名、形参列表必须一致
 *  -
 */
public class Student extends Person {
    private String sno;


    @Override
    public void eat() {
        System.out.println("吃食堂的饭");
    }

    @Override
    public void sleep() {
        System.out.println("在寝室睡觉");
    }

    public void study(){
        System.out.println("学生学习");
    }
}
