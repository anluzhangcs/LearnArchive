package demo;

/**
 * @author: zhanghao
 * @date: 2021/10/9-10:28
 */

import org.junit.Test;

import java.util.*;

/**
 * @Description 集合中泛型的使用
 */
public class GenericTest {

    @Test
    //JDK5.0之前:没有使用泛型
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(345);
        list.add(456);
        list.add(567);
        //问题1:类型不安全
//        list.add("AA");

        for (Object o : list) {
            //类型转换异常:ClassCastException
            Integer i = (Integer) o;
            System.out.println(i);
        }
    }

    //JDk5.0,集合增加了泛型支持
    @Test
    //Collection,以ArrayList为例
    public void test2() {
        /*
        Explicit type argument Integer can be replaced with <>
        This inspection reports all new expressions with type arguments
        which can be replaced with diamond type <>
        Such<> syntax is not supported under Java 1.6 or earlier JVMs.
        注:在创建有泛型声明类的对象时,后面的显示类型参数可以用<>替代,避免冗余
        */
        //ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(65);
        list.add(65);
        list.add(90);
        list.add(78);
        //使用泛型之后,add(E e)-->add(Integer e),在编译时会进行类型检查,不符合类型的会报错
//        list.add("A");

        //Iterator接口也使用了泛型,而iterator()的返回值为Iterator<E>
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    //Map中的泛型:以HashMap为例
    public void test3() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Math", 95);
        map.put("English", 95);
        map.put("YUWEN", 95);
        map.put("DILI", 95);
        //类型检查
//        map.put(123, "AA");


        /*
         * 注意点:
         *  -entrySet(),返回的是Set,Set里面装的是Entry,一个键值对组成一个Entry
         *  -Entry是内部接口,对外隐藏,在外使用需要用Map.Entry
         *  -泛型的嵌套 <>里面是存放数据的具体类型
         */
        Set<Map.Entry<String,Integer>> set = map.entrySet();

        Iterator<Map.Entry<String,Integer>> iterator =  set.iterator();
        while (iterator.hasNext()) {
            //获取entry,注意entry的类型
            Map.Entry<String,Integer> entry = iterator.next();
            //获取key
            String key = entry.getKey();
            //获取value
            Integer value = entry.getValue();
            System.out.println(key + "-->" + value);

            //也可以直接输出
//            System.out.println(entry);
        }
    }
}
