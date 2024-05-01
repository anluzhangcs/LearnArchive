package object_class;

/**
 * @author: zhanghao
 * @date: 2021/9/12-11:18
 */

import java.util.Arrays;

/**
 * @Description Object类
 * 特点：
 *      -Object类是所有类的根父类
 *      -无属性，只有一个无参的构造器
 *      -有一些通用的方法
 * 方法：equals();toString();getClass();hasCode();...
 * ① "=="运算符和equals()的区别
 *  ==运算符：
 *      -基本数据类型 比较值
 *          一个类型的基本都可以比较 如char==int int==double...
 *          boolean不参加运算
 *      -引用数据类型 比较地址值
 *  equals()方法:
 *      -基本数据类型不适用，要通过对象引用
 *      -引用数据类型
 *          没有重写Object类equals()方法的，比较的依旧是地址值
 *          重写了equals()方法的，一般比较的是内容
 */
public class Test1 {
    public static void main(String[] args) {
        char c = 65;
        int i1 = 65;
        int i2 = 1;
        boolean b = true;
        System.out.println(c==i1);
//        System.out.println(i2==b);
        System.out.println("*****************************");
        Order order1 = new Order(1, "sfsdf");
        Order order2 = new Order(1, "sfsdf");
        System.out.println(order1.equals(order2));
        System.out.println("*****************************");
        char[] arr = {'1','2','4'};
        char[] arr2 = {'1','2','4'};
        System.out.println(Arrays.equals(arr,arr2));
        System.out.println(Arrays.toString(arr));
    }
}
