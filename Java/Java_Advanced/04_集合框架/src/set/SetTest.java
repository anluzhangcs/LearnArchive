package set;

/**
 * @author: zhanghao
 * @date: 2021/10/7-17:04
 */

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @Description Set接口及其实现类
 *  |----HashSet:主要实现类,线程不安全,可以存放NUll
 *      |----LinkedHashSet:HashSet的基础上增加了双向链表,频繁遍历的效率高
 *  |----TreeSet
 *
 *  1.Set接口
 *      ①Set存放无序的,不可重复的序列
 *      ②Set接口中没有新增方法
 *
 *  2.无序性和不可重复性
 *      无序性:Set中的元素根据哈希值来存放,而不是下标索引,是这种意义上的无序
 *              并不是随机性,且存放之后就不会改变
 *      不可重复性:Set中不会出现两个相同的元素
 *
 *  3.add操作 (以HashSet为例)
 *      HashSet底层是HashMap或者说是既有数组,也有链表
 *      add(E e)
 *      首先得到它的hashCode()哈希值通过算法来确定要放在数组中那个位置
 *      -若该位置上没有元素,则直接添加成功
 *      -若该位置上有元素,则与该数组位置及所有的链表元素的哈希值进行比较
 *          -若都不相等,则添加成功
 *          -若相等,则调用equals方法进行比较
 *              -若为true,则添加失败
 *              -若为false,则添加成功
 *      注:
 *      -哈希值是根据对象属性值来计算的.哈希值相等的对象一般相同,哈希值不等的对象一般不同
 *      -元素添加位置首先都是数组上,若数组上该位置有元素,则添加到指向的链表上
 *          -jdk1.7 新元素放在数组上,指向链表
 *          -jdk1.8 新元素放在链表末尾
 *
 */
public class SetTest {

    @Test
    public void test1() {
        HashSet set = new HashSet();
        set.add(123);
        set.add("123");
        set.add("AA");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        System.out.println(set);
    }

    @Test
    public void test2() {
        LinkedHashSet set = new LinkedHashSet();
        set.add(123);
        set.add("123");
        set.add("AA");
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));
        System.out.println(set);

    }
}
