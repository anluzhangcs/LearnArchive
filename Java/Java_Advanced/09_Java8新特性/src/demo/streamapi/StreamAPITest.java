package demo.streamapi;

/**
 * @author: zhanghao
 * @date: 2021/10/21-16:58
 */

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Description StreamApI 用于操作数据,如Collection和数组
 *  StreamAPI操作数据源,和CPU相关
 *  集合和数组是容器,和内存相关
 *
 *  ①Stream 自己不会存储元素。
 *  ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 *  ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 *
 *  1.获取流,需要提供数据源
 *      ①调用Collection接口中的default Stream<E> stream() ==>顺序流或者
 *      parallelStream()==>并行流方法, 适用于Collection所有实现类
 *      ②调用Arrays.stream(T[] arr),适用于数组
 *      ③Stream接口的静态方法of(T ...values)
 *      ④创建无限流
 *          Stream.iterate(seed,UnaryOperator<T> f)迭代流
 *          Stream.generate(Supplier<?> s)生成流
 *
 */
public class StreamAPITest {

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        Stream<String> parallelStream = list.parallelStream();

        //不适用于Map
        HashMap map = new HashMap();


        int[] arr = new int[5];
        IntStream intStream = Arrays.stream(arr);
    }

    @Test
    public void tset2() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
    }

    @Test
    public void test3() {
        //无限迭代流
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        //无限生成流
//        Stream<Double> generate = Stream.generate(() -> Math.random()); //lambda表达式
        Stream<Double> generate = Stream.generate(Math::random);
        generate.limit(5).forEach(System.out::println);

    }
}
