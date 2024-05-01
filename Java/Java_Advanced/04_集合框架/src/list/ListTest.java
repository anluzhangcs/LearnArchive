package list;

/**
 * @author: zhanghao
 * @date: 2021/10/7-12:04
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @Description List接口实现类
 *   |----ArrayList:常用实现类.线程不安全,效率高
 *   |----LinkedList:若需要频繁的插入删除操作,则LinkedList效率较ArrayList高
 *   |----Vector:不常用.List古老实现类,线程安全,效率低,底层为Object[]数组elementData
 *
 *   2.ArrayList源码分析
 *      jdk1.7
 *      底层为Object[] elementData
 *      ArrayList a = new ArrayList()//创建一个长度为10的数组
 *      a.add(E e) //
 *      ...
 *      a.add(E e)
 *      扩容为原来的1.5倍
 *
 *      jdk1.8
 *      底层为Object[] elementData
 *      ArrayList a = new ArrayList()//elementData={}
 *      a.add(E e) //只有当add操作时,才会创建数组
 *      ...
 *      a.add(E e)
 *      扩容为原来的1.5
 *
 *
 *   3.LinkList源码分析
 *      底层为双向链表
 *      private static class Node<E> {
 *         E item;
 *         Node<E> next;
 *         Node<E> prev;
 *
 *         Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 *     不存在扩容问题
 *
 *
 *   4.Vector源码分析:
 *      protected Object[] elementData;
 *      Vector vector = new Vector();//创建数组长度为10的Object[] elementData
 *      vector.add(E e) //每次add之前都要检查容量是否足够
 *      ...
 *      vector.add(E e)
 *      当超过容量要扩容时,扩容两倍
 *
 *   总结:
 *      ①底层为数组的,最好使用带参的构造器,避免频繁的扩容问题
 *      ②ArrayList1.8比1.7主要是延迟了elementData数组的创建时间,节省了内存
 */
public class ListTest {

    /*
     * @Description  List常用方法
     *  获取长度:size()
     *  判断为空:isEmpty()
     *  增:add(E e) add(int index,E e) addAll(Collection c) addAll(int index,Collection c)
     *  删:remove(int index) remove(Object o) removeAll(Collction c)
     *  改:set(int index,Object element),返回旧的元素
     *  查:get(int index) indexOf(Object o) lastIndexOf(Object o)
     *  遍历:
     *      Iterator迭代器
     *      for-each
     *      普通for循环
     */

    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("AA");
        list.add(new Date());

        System.out.println(list.isEmpty());

        for (Object o:list
             ) {
            System.out.println(o);
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add("AA");
        list.add(new Date());
        System.out.println(list.toString());

        list.set(1, "CC");


        list.remove(1);
        list.remove("BB");
        System.out.println(list);
        System.out.println(list.size());

    }
}
