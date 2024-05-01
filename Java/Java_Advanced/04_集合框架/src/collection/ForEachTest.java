package collection;

/**
 * @author: zhanghao
 * @date: 2021/10/2-21:39
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Description for-each 增强for循环
 *  -可用于遍历集合等容器和数组
 *  -就是for循环的增强版
 */
public class ForEachTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("Tom");
        coll.add(new Person("Jerry", 21));
        coll.add(false);

        //for (元素类型 局部变量 : 集合对象)
        //对于集合对象,本质上还是调用Iterator迭代器
        for (Object o : coll) {
            System.out.println(o);
        }
    }

    @Test
    public void test2() {
        String[] arr = new String[]{"AA","BB","CC"};


        //for(元素类型 局部变量 : 数组对象)
        for (String s: arr) {
            System.out.println(s);
        }
    }

    @Test
    //面试题
    public void test3() {

        String str = "Albert";
        str = "Zhangsan";
        System.out.println(str);
        String[] arr = new String[]{"MM", "MM", "MM"};

        for (int i = 0; i < arr.length; i++) {
            //通过str本身去改,str会有新的地址值
            arr[i] = "GG";
        }

        for (String s : arr) {
            //通过迭代器Ierator将arr元素赋给s,通过s去改,由于不变性,arr元素本身没有变
            s = "MM";
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
