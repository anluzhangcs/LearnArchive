package diy;

/**
 * @author: zhanghao
 * @date: 2021/10/9-13:08
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 */
public class Test1 {


    @Test
    public void test5() {
        //
        List<? extends Object> list = new ArrayList<Object>();

        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();

        //编译不通过
//        list1 = list2;

        //编译通过,List<?>是List各种泛型类的父类
//        list = list1;
//        list = list2;

        //编译不通过,使用通配符?不能写入,不能确定e的类型
//        list.add(21);
        //null可以,因为任何类型都可以是null
        list.add(null);

//        list.add(new Object());

        //可以读取,因为Object是根父类
        Object o = list.get(0);
        System.out.println(o);
    }


    /*
     * @Description 通配符的使用
     *  原因:
     *  泛型的继承问题:两个父类或者接口引用如果指向两个不同泛型的实例化对象,
     *      则他们之间是不能相互赋值的.
     *      ==>导致有泛型继承关系的类中都需要重载
     *
     */
    @Test
    public void test4() {

        //Object是String的父类,数组中可以将arr2赋给arr1
        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        //在集合中,不能
        List<Object> list1 = null;
        List<String> list2 = null;
//        list1 = list2;

        //若泛型一致,两个对象的类是继承或者实现关系,则可以
        ArrayList<String> list11 = null;
        List<String> list22 = null;
        list22 = list11;
    }


    @Test
    public void tset3() {
        Person<String> person = new Person<>();
        person.show("AA");
    }

    @Test
    public void test2() {
        MyGI<Integer> son = new MyGI<>("A",21,20);
        SubClass s = new SubClass();
        s.show();
    }

    @Test
    public void test1() {
        MyGI<Date> myGI = new MyGI<>();
        myGI.setT(new Date());
        System.out.println(myGI);
    }

}
