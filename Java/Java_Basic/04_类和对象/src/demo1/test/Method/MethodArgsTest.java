package demo1.test.Method;

/**
 * @author: zhanghao
 * @date: 2021/9/10-14:01
 */

import demo1.java.Method.MethodArgs;

/**
 * @Description 可变个数的形参测试
 */
public class MethodArgsTest {
    public static void main(String[] args) {
        MethodArgs ma = new MethodArgs();
        ma.show("AAA");
        ma.show("AAA","BBB","CCC");
        ma.show(1);
    }
}
