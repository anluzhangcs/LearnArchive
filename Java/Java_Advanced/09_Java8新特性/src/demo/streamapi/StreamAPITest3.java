package demo.streamapi;

/**
 * @author: zhanghao
 * @date: 2021/10/21-19:14
 */

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description Stream终止操作
 *  -流一旦终止,要想使用就需要重新造
 *  -终止操作后,中间操作才会执行
 */
public class StreamAPITest3 {

    @Test
    /*
     * @Description  1-匹配与查找
     * allMatch(Predicate p) 检查是否匹配所有元素
        anyMatch(Predicate p) 检查是否至少匹配一个元素
        noneMatch(Predicate p) 检查是否没有匹配所有元素
        findFirst() 返回第一个元素
        findAny() 返回当前流中的任意元素
     */
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();

        boolean allMatch = employees.stream().allMatch(employee -> employee.getSalary() > 6000);
        System.out.println(allMatch);

        boolean anyMatch = employees.stream().anyMatch(employee -> employee.getAge() < 18);
        System.out.println(anyMatch);

        boolean noneMatch = employees.stream().noneMatch(employee -> employee.getAge() < 18);
        System.out.println(noneMatch);

        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);
    }

    @Test
    /*
     * @Description
     *  count() 返回流中元素总数
        max(Comparator c) 返回流中最大值
        min(Comparator c) 返回流中最小值
        forEach(Consumer c)内部迭代(使用 Collection 接口需要用户去做迭代，
            称为外部迭代。相反，Stream API 使用内部迭代——它帮你把迭代做了)
     */
    public void test2() {
        List<Employee> employees = EmployeeData.getEmployees();
        employees.forEach(System.out::println);

        long count = employees.stream().count();
        System.out.println(count);

        Optional<Employee> max = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max);

        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getAge(), e2.getAge()));
        System.out.println(min);

        employees.stream().forEach(System.out::println);
    }

    @Test
    /*
     * @Description  2.归约
     * -一般和map配套使用
     *  reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一
            个值。返回 T,iden为初始值
        reduce(BinaryOperator b)可以将流中元素反复结合起来，得到一
            个值。返回 Optional<T>
     */
    public void test3() {
        List<Employee> employees = EmployeeData.getEmployees();

        Double reduce = employees.stream().map(Employee::getSalary).reduce(0.0, Double::sum);
        System.out.println(reduce);
    }

    @Test
    //收集
    public void test4() {

//  collect(Collector c) 将流转换为其他形式。接收一个 Collector
//  接口的实现，用于给Stream中元素做汇总的方法
        List<Employee> list = EmployeeData.getEmployees();
        //toList 把流中元素收集到List
        List<Employee> emps= list.stream().collect(Collectors.toList());
        //toSet  把流中元素收集到Set


        Set<Employee> emps1= list.stream().collect(Collectors.toSet());

        //toCollection/把流中元素收集到创建的集合
        Collection<Employee> emps2 =list.stream().collect(Collectors.toCollection(ArrayList::new));
    }
}
