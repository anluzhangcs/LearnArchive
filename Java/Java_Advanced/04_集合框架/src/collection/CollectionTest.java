package collection;

/**
 * @author: zhanghao
 * @date: 2021/10/2-14:49
 */

import org.junit.Test;

import java.util.*;

/**
 * @Description Java集合框架
 *  1.集合框架的引入:数组Array的局限性
 *      ①数组的长度一旦初始化后就不能改变
 *      ②数组的元素类型一旦初始化也是确定的
 *      ③尽管有Arrays工具类,但数组的一些操作还是不方便.如增删,获取数组元素个数等
 *      ④数组是有序的,可重复的.
 *
 *  2.集合框架:
 *      |----Collection(I)     存储单列数据
 *          |----List(I)       类似于数组,有序的,可重复
 *              |----ArrayList(C) LinkedList(C) TreeList(C)...
 *          |----Set(I)         类似于数学中的集合,无序,不可重复
 *              |----LinkedSet(C) TreeSet(C)...
 *      |----Map(I)            存储键值对数据
 *          |----HashMap(C) ...
 */
public class CollectionTest {

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("Tommy");
        coll.add(new Date());
        coll.add(new Person("Jerry", 21));
        coll.add(456);
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("Tommy");
        coll.add(new Date());
        coll.add(new Person("Jerry", 21));
        coll.add(456);

        //contains(obj)  判断是否包含obj
        //containsAll(Collection c) 判断是否包含c中的全部元素
        //注:上述中判断是都调用了equals()方法,逐个比较判断的是内容是否相等
        //   containsAll(Collection c)只需判断内容是否在,不用管顺序
        System.out.println(coll.contains(123));
        System.out.println(coll.contains(new Date()));
        System.out.println(coll.contains(new Person("Jerry", 21)));
        Collection coll1 = Arrays.asList(123, 456);
        System.out.println(coll.containsAll(coll1));

        //remove(obj)   移除obj,同样要调用equals方法先判断coll中是否有obj
        //removeAll(coll) 相当于数学集合A-B,移除交集元素
        System.out.println(coll.remove(1234));
        System.out.println(coll);
        Collection coll2 = Arrays.asList(123, 4567);
//        coll.removeAll(coll2);
        System.out.println(coll);

        //retainAll(coll) 相当于数学集合A∩B,留下交集元素
        System.out.println(coll.retainAll(coll2));
        System.out.println(coll);

        //equals(obj)   要想返回true,则要为两个集合且数据相同
        System.out.println(coll.equals(coll1));

        //toArray() 将Collction转换为数组
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        //Arrays.asList(T... a)   将数组转换为Collection
        List<String> strings = Arrays.asList(new String[]{"AA", "BB", "CC"});

    }

    /*
     * @Description Collection常用方法
     *
     */
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        /*
         * add(E e) 添加元素
         * addAll(Collection c)可以直接添加另一个集合
         */
        coll.add(123);
        coll.add("AA");
        coll.add(new Date());
        System.out.println(coll);
        Collection coll1 = new ArrayList();
        coll1.add("BB");
        coll1.add(456);
        coll.addAll(coll1);
        System.out.println(coll);

        //size()    返回集合数据的个数
        int size = coll.size();
        System.out.println(size);

        //clear()   清空集合中数据
        coll.clear();

        //isEmpty() 判断集合中是否没有数据
        boolean b = coll.isEmpty();
        System.out.println(b);

    }
}
