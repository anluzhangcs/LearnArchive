package map;

/**
 * @author: zhanghao
 * @date: 2021/10/8-17:51
 */

import org.junit.Test;

import java.util.*;

/**
 * @Description Map接口及其实现类 存储键值对,key:value
 *  |---HashMap:Map主要实现类.线程不安全,效率高;可以存储键值都为null
 *      |---LinkedHashMap:在HashMap基础上加上双向链表,适合频繁的遍历操作,
 *                          可以按照添加顺序遍历出键值对
 *  |---TreeMap:遍历时可以对键值对进行排序之后输出,不能存储键值对为null
 *  |---Hashtable:Map古老实现类.线程安全,效率低;不能存储键值对为null
 *      |---Properties:主要用于配置文件,key:value都为String类型
 *
 *  1.Map的键值对结构:
 *      -key是无序的,不可重复的.用Set储存
 *          注:key如果是自定义类,且用HashSet储存,则要重写equals()和hashCode()
 *      -value是无序的,可重复的.用Collection储存.要重写equals方法
 *      -一个键值对-->一个Entry单位,Enter是无序的,不可重复的,用Set储存
 *
 *  2.Map的底层结构
 *      jdk7及之间:数组+双向链表
 *      jdk8:数组+双向链表+红黑树
 *
 *  3.HashMap底层实现原理
 *      jdk7:数组+双向链表
 *      HashMap map = new HashMap() //创建了长度为16的Entry[]数组
 *      map.put(key,value)
 *      ...
 *      put操作:
 *          -获取key的哈希值,根据算法定位到key要存储的数组位置,并判断该位置上是否有元素
 *              -若没有元素,则键值对key-value添加成功;
 *              -若有元素,则比较哈希值,
 *                  -若没有一个相等,添加成功
 *                  -若相等,则调用equals方法比较key是否相同
 *                      -若不相同,添加成功
 *                      -若相同,则修改key的value值为新的value值
 *      扩容问题:
 *          底层数组扩容为原来的2被
 *
 *      jdk8:数组+双向链表+红黑树
 *      与jdk7的区别:
 *      -jdk8中底层数组为Node[],而不是Entry[];
 *      -创建HashMap对象时,并不会立马创建数组,首次put操作时才会创建数组
 *      -数组索引位置的双向链表长度>8 && 数组长度超过64时,该索引位置的双向链表会重构为红黑树
 *
 */
public class MapTest {

    /*
     * @Description  Map常用方法
     * put(key,value)   添加元素
     * putAll(Map map)  添加map中所有元素
     * remove(key)  删除指定key的元素,并将值返回
     * remove(key,value) 删除指定元素 boolean
     * clear()      清空所有元素
     * containsKey(key) 判断键中是否包含key
     * containsValue(value) 判断值中是否包含value
     * get(key)     获取键key的值value,若没有,则返回null
     *
     * 遍历操作:
     * values() 获取map的所有值并返回一个Collection对象
     * KeySet() 获取map的所有键并返回一个Set对象
     * entrySet() 获取map中所有键值对并返回一个Set对象
     */
    @Test
    public void test2() {
        Map<String, Integer> map = new HashMap();
        map.put("A", 65);
        map.put("a", 97);
        map.put("B", 23);
        map.put("B", 66);
        System.out.println(map);
        boolean a = map.containsKey("A");
        boolean b = map.containsValue(66);

        Integer integer = map.get("C");
        System.out.println(integer);

        Integer c = map.remove("B");
        System.out.println(c);
        System.out.println(map);

        Collection<Integer> values = map.values();
        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Set<String> strings = map.keySet();
        Iterator<String> iterator1 = strings.iterator();
        for (String s: strings) {
            System.out.println(s);
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println(entries);


    }

    @Test
    public void test1() {
        Map map = new HashMap();
        map.put(null, null);
        System.out.println(map);
    }
}
