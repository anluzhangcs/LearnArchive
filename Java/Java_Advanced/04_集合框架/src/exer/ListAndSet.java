package exer;

/**
 * @author: zhanghao
 * @date: 2021/10/7-21:45
 */



import collection.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description
 */
public class ListAndSet {

    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(12);
        list.add(21);
        list.add(21);
        list.add(34);
        List list1 = duplicateFun(list);
        for (Object o : list1) {
            System.out.println(o);
        }
    }

    @Test
    //HashSet经典例题
    public void test2() {
        HashSet set = new HashSet();
        Person p1 = new Person("AA", 1001);
        Person p2 = new Person("BB", 1002);
        set.add(p1);
        set.add(p2);
        System.out.println(set);
        //[Person{name='BB', age=1002}, Person{name='AA', age=1001}]

        p1.setName("CC");
        /*注:此时remove(p1),HashSet操作首先要根据哈希值从而找到位置,
        而此时p1已经改变,故它的哈希值也改变,找到的位置为空,故而没有删除p1
         */
        set.remove(p1);
        System.out.println(set);
        //[Person{name='BB', age=1002}, Person{name='CC', age=1001}]

        Person p3 = new Person("AA", 1001);
        //此时根据p3的哈希值找到了p1的位置,该位置已经有元素,所以调用equals方法,返回为false,添加成功
        set.add(p3);
        System.out.println(set);
    }

    //去除List中的重复元素
    List duplicateFun(List list) {
        //1.创建Set实现类对象   ---->Set是不可重复的
        Set set = new HashSet();

        //2.将List实现类对象作为参数添加到set中 ---->List是Collection的子接口
        //注:若此时list实现类对象是自定义类,则需要重写equals和hashCode方法
        set.addAll(list);

        //3.将set作为ArrayList构造器参数创建List对象
        List list1 = new ArrayList(set);

        //4.返回List对象
        return list1;
    }
}

class People{
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        People people = (People) o;

        if (id != people.id) return false;
        return name != null ? name.equals(people.name) : people.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public People(int id, String name) {

        this.id = id;
        this.name = name;
    }

    public People() {

    }
}
