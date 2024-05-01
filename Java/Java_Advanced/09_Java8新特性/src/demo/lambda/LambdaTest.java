package demo.lambda;

/**
 * @author: zhanghao
 * @date: 2021/10/20-17:27
 */

import org.junit.Test;

/**
 * @Description Lambda表达式的使用 ==>使代码更简洁
 *   格式: () -> {};
 *      -> :lambda操作符 或 箭头操作符
 *      ->左边: 接口实现类重写方法的形参列表
 *          -一般情况下都可以使用类型推断来省略参数类型
 *          -如果只有1个参数,则可以省略();0或多个都不能省略
 *
 *      ->右边: 接口实现类重写方法的方法体
 *          -如果方法体只有一条语句,则可以省略{},若这条语句还有返回值,则
 *              必须省略返回值
 *   总结:lambda表达式的本质就是函数式接口实现类的对象,不能脱离接口使用,
 *   且只适用于只有一个方法的接口
 *
 */
public class LambdaTest {

    @Test
    public void test1() {
        //lambda使用之前的常规写法
        Comparable<String> com1 = new Comparable<String>() {
            @Override
            public int compareTo(String o) {
                return "asb".compareTo(o);
            }
        };

        //lambda语法
        Comparable<String> com2 = str ->
//            System.out.println("使用了lambda");
            "asb".compareTo(str);
        System.out.println(com2.compareTo("abc"));
    }

}
