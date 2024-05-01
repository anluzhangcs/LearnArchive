package demo.lambda;

/**
 * @author: zhanghao
 * @date: 2021/10/21-9:34
 */

import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Description 方法引用
 *  -本质上是lambda表达式,也就是函数式接口实例
 *  -方法引用是lambda表达式的进一步简化
 *  -方法引用适用于实现方法的方法体和抽象方法的形参列表和返回值有一定联系
 *
 *  格式:  类或对象 :: 方法名
 *      对象 :: 实例方法
 *          函数式接口的抽象方法返回值和形参列表和实现方法方法体是一致的
 *      类 :: 静态方法
 *          函数式接口的抽象方法返回值和形参列表和实现方法方法体是一致的
 *      类 :: 实例方法
 *          函数式接口抽象方法形参个数比实现方法的方法体函数多一个,且方法体为
 *          形参调用方法,见test3
 */
public class MethodReferenceTest {

    @Test

    //Consumer<T> void accept(T t)
    //PrintStream<T> void println(T t)
    public void test1() {
        //方法体中的操作函数和抽象方法返回值和参数列表一致
        Consumer<String> con = str -> System.out.println(str);
        con.accept("账单");


        System.out.println("********方法引用*********");
        Consumer<String> con1 = System.out :: println; //对象::实例方法
        con1.accept("和西安交大");

    }

    @Test
    //Function<T,R> R apply(T t)
    //Math          static long round(double d)
    public void test2() {
        Function<Double,Long> fun = t -> Math.round(t);
        System.out.println(fun.apply(12.3));

        System.out.println("********方法引用*********");
        Function<Double,Long> fun1 = Math::round; //类::静态方法
        System.out.println(fun1.apply(12.6));

    }

    @Test
    //Comparator<T>    int compare(T t1,T t2)
    //String           int t1.compareTo(t2)
    public void test3() {
        Comparator<String> com = (t1, t2) -> t1.compareTo(t2);
        System.out.println(com.compare("abc", "abd"));

        System.out.println("********方法引用*********");
        Comparator<String> com1 = String :: compareTo; //类::实例方法
        System.out.println(com1.compare("abd", "ae"));
    }



    @Test
    /*
     * @Description  构造器引用
     *  -也是方法引用的一种,可以把构造器看成方法
     *
     *  格式: 类::new
     */
    //Supplier<T>  T get()
    //Employee     Employee()
    public void test4() {
        Supplier<Employee> sup = () -> new Employee();
        System.out.println(sup.get());

        System.out.println("***********构造器引用*******");

        Supplier<Employee> sup1 = Employee::new;
        System.out.println(sup1.get());
    }

    @Test
    //Function<T,R>  R apply(T t)
    //Employee       new Employee(String name)
    public void test5() {
        Function<String, Employee> fun = name -> new Employee(name);
        System.out.println(fun.apply("张安"));

        System.out.println("***********构造器引用*******");
        Function<String,Employee> fun1 = Employee::new;
        System.out.println(fun1.apply("李四"));

        BiFunction<String, Integer, Employee> biFun = (name, id) -> new Employee(name, id);
        System.out.println(biFun.apply("王五", 1001));

        System.out.println("***********构造器引用*******");
        BiFunction<String,Integer,Employee> biFun1 = Employee::new;
        System.out.println(biFun1.apply("狗仔", 1002));

    }

    @Test
    /*
     * @Description  数组引用
     *      -也是方法引用的一种,也已将数组看成对象,就和构造器引用一样
     *      格式: 类型[] :: new
     */
    //Function<T,R>   R apply(T t)
    //
    public void test6() {
        Function<Integer, String[]> fun = len -> new String[len];
        String[] arr = fun.apply(5);
        System.out.println(Arrays.toString(arr));

        System.out.println("********数组引用*********");
        Function<Integer,String[]> fun1 = String[] :: new;
        String[] arr1 = fun1.apply(6);
        System.out.println(Arrays.toString(arr1));

    }


}
