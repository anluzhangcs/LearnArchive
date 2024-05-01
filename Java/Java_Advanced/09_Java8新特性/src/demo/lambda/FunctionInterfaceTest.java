package demo.lambda;

/**
 * @author: zhanghao
 * @date: 2021/10/20-22:20
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Description 函数式接口 java.util.function
 *  -内部只有一个抽象方法
 *  -可以用@FunctionalInterface注解检查
 *
 *  四大核心函数式接口
 *    消费型接口 Consumer<T>    void accept(T t)
 *    供给型接口 Supplier<T>    T get()
 *    函数型接口 Function<T,R>  R apply(T t)
 *    检验型接口 Predicate<T>  boolean test(T t)
 *
 */
public class FunctionInterfaceTest {

    @Test
    public void test1() {
        shopping(500, money -> System.out.println("我消费了" + money));

    }
    //消费性接口例
    public void shopping(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京", "天津", "东京", "西京");
        List<String> res = fliterString(list, str -> str.contains("京"));
        System.out.println(res);
    }

    //检验型接口例
    public List<String> fliterString(List<String> list, Predicate<String> pre) {
        List<String> res = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                res.add(s);
            }
        }
        return res;
    }
}
