package demo.streamapi;

/**
 * @author: zhanghao
 * @date: 2021/10/21-18:38
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description Stream的中间操作
 */
public class StreamAPITest2 {

    @Test
//    1-筛选与切片

    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();

//    filter(Predicate p) 从流中排除某些不符合元素
        employees.stream().filter(employee -> employee.getAge() < 18).forEach(System.out::println);

//    distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        employees.stream().distinct().forEach(System.out::println);

//    limit(long maxSize) 截断流，使其元素不超过给定数量
        employees.stream().limit(4);
//    skip(long n) 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        employees.stream().skip(3);
    }

    @Test
    /*
     * @Description  映射
     *  map(Function f) 接收一个函数作为参数，该函数会被应用到每个元
        素上，并将其映射成一个新的元素。
        flatMap(Function f)
        接收一个函数作为参数，将流中的每个值都换成另
        一个流，然后把所有流连接成一个流
     */
    public void test2() {
        List<Employee> employees = EmployeeData.getEmployees();

        //map其实一般用来获取所有对象的某个属性值的
        Stream<Double> doubleStream = employees.stream().map(e -> e.getSalary());

        List<String> list = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest2::fromStringToStream);
        characterStream.forEach(System.out::println);
    }
    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){//aa
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    @Test
    //排序
    public void test3() {
        List<Employee> employees = EmployeeData.getEmployees();

        //sorted() 自然排序(升序,要求排序对象实现Comparable接口)
        employees.stream().map(e->e.getSalary()).sorted().forEach(System.out::println);

        System.out.println();
        //sorted(Comparator<?> com) 定制排序
        employees.stream().sorted((s1, s2) ->
                Double.compare
                        (s1.getSalary(), s2.getSalary())).forEach(System.out::println);
    }
}
