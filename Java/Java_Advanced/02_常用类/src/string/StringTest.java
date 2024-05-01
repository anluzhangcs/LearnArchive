package string;

/**
 * @author: zhanghao
 * @date: 2021/9/25-21:31
 */

import org.junit.Test;

/**
 * @Description String类
 *
 */
public class StringTest {

    /*
     * @Description  字符串拼接问题
     * -两个常量相+,返回值还是在常量中
     * -只要有一个变量,就会在堆空间中创建一个新的对象
     * -堆空间的对象调用intern()方法,返回值为常量池中的地址值
     */
    @Test
    public void test4() {
        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";

        String s4 = "hello" + "world";
        String s5 = s1 + "world";
        String s6 = s5.intern();
        String s7 = "hello" + s2;

        System.out.println(s3 == s4); //true
        System.out.println(s3 == s5); //false
        System.out.println(s3 == s6); //true
        System.out.println(s3 == s7); //false
    }

    @Test
    //字符串内存解析
    public void test3(){
        String s1 = "javaEE";
        String s2 = "javaEE";
        String s3 = new String("javaEE");
        String s4 = new String("javaEE") ;
        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); //false
        System.out.println(s1 == s4); //false
        System.out.println(s3 == s4); //false
    }

    /*
     * 两种实例化方式
     *         //字面量赋值
     *
     */
    @Test
    public void test2(){
        //字面量赋值
        String s1 = "JavaEE";
        //new+构造器实例化
        String s2 = new String("JavaEE");
        System.out.println(s1==s2);//false
    }

    @Test
    /*
     *  1.String类是final,不能被继承
     *  2.String实现了Serializable接口:可被序列化
     *  3.String实现了Comparable接口:可以使用equals()比较
     *  4.String是不可变的字符序列,final char value[];
     *        -使用字面量对String对象赋值,内容放在方法区的常量池
     *        -常量池中相同的内容只有一份
     *        -字符串拼接也会在常量池中开辟新的内存
     *        -字符串替换是replace()会在常量池中开辟新的内存
     */
    public void test1(){
        String s1 = "hello";  //字面量赋值
        String s2 = "hello";
        System.out.println(s1 == s2);
        String s3 = s2.replace("he", "fu");
        System.out.println(s2);
        System.out.println(s3);

    }
}
