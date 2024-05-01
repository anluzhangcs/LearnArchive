package wapper_test;

/**
 * @author: zhanghao
 * @date: 2021/9/12-16:02
 */

import org.junit.Test;

/**
 * @Description 基本数据类型，包装类，String之间相互的转换
 * -包装类：将基本数据类型封装成类
 * 如Interger
 */
public class TestWapper {

    /*
     * @Description  基本数据类型转换为包装类
     * 方式一：参数可以为对应的基本数据类型也可以为String，
     *        如果为String又调用相应的parsexxx方法
     *      Integer integer = new Integer(3);
            Double d = new Double("3.14");
            Boolean b1 = new Boolean(true);
            //不区分大小写，只要不为true，就是false
            Boolean b = new Boolean("faslsd");
     *方式二：自动封箱,此时类型要相对应，不能用String
     *      Integer in1 = 2;
     * @param null
     * @return
     */
    @Test
    public void Test1(){
        Integer integer = new Integer(2);
        Double d = new Double(3.14);
        Boolean b1 = new Boolean(true);
        Boolean b = new Boolean("faslsd");
        Integer in1 = 2;
        System.out.println(b);
    }

    /*
     * @Description  包装类转换为基本数据类型
     * 方式一：int i1 = in1.intValue();
     *
     * 方式2：自动开箱
     *      Integer in1 = 2;
            int i = in1;
     *
     * @param
     * @return  void
     */
    @Test
    public void Test2(){
        Integer in1 = 2;
        int i = in1;
        int i1 = in1.intValue();
        System.out.println(i1);
    }

    @Test
    /*
     * @Description  基本数据类型，包装类 ==> String
     * 方法一： String.valueOf()方法
     *  String str = String.valueOf(integer);
        String str2 = String.valueOf(d);
     *
     *  方法二：+运算
     * @param
     * @return  void
     */
    public void Test3(){
        Integer integer = 1;
        double d = 3.14;
        String str = String.valueOf(integer);
        String str2 = String.valueOf(d);
        System.out.println(str);
        System.out.println(str2);
    }

    @Test
    /*
     * @Description  String ==> 基本数据类型，包装类
     * Integer.parseInt(str)
     * Double.parseDouble(str)
     * Boolean.parseBoolean(str)
     *
     * @param
     * @return  void
     */
    public void test4(){
        String str = "123";
        String str1 = "3.14";
        String str2 = "true";
        String str3 = "safsd";
        System.out.println(Integer.parseInt(str));
        System.out.println(Double.parseDouble(str1));
        System.out.println(Boolean.parseBoolean(str2));
        System.out.println(Boolean.parseBoolean(str3));
    }

    @Test
    public void method1() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); //false
        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);//true
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);//fasle
    }
}
