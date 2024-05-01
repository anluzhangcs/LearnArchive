package set;

/**
 * @author: zhanghao
 * @date: 2021/10/7-18:23
 */

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Description TreeSet
 *      -以树状方式(红黑树)存储,对象类型要一致
 *      -遍历是按照排序进行的
 *      -若为基本数据类型或者String,他们已经实现了CompareTo()方法
 *      -若存储一般类对象,则必须实现Comparable接口或者用Comparator创建TreeSet
 *
 *  排序方式:Java比较器
 *          自然排序:实现CompareTo方法
 *          定制排序:用实现Comparator接口的对象作为形参创建TreeSet
 *  注:TreeSet中的不可重复性是由CompareTo()或者Compare()实现的,而不是equals()
 */
public class TreeSetTest {

    @Test
    public void test3() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    int res = -u1.getName().compareTo(u2.getName());
                    if (res != 0) {
                        return res;
                    } else{
                        return Integer.compare((u1.getAge()), u2.getAge());
                    }
                } else
                    throw new RuntimeException("类型不匹配");

            }
        };
        TreeSet set = new TreeSet(comparator);
        set.add(new User("Tom", 23));
        set.add(new User("Albert", 32));
        set.add(new User("Tom", 28));
        set.add(new User("Jack", 23));
        set.add(new User("Dick", 24));
        set.add(new User("Jerry", 22));

        for (Object user:set
                ) {
            System.out.println(user);
        }
    }

    @Test
    public void test2() {
        TreeSet set = new TreeSet();
        set.add(new User("Tom", 23));
        set.add(new User("Albert", 32));
        set.add(new User("Tom", 28));
        set.add(new User("Jack", 23));
        set.add(new User("Dick", 24));
        set.add(new User("Jerry", 22));

        for (Object user:set
             ) {
            System.out.println(user);
        }
    }

    @Test
    public void test1() {
        TreeSet set = new TreeSet();
        set.add(123);
        set.add(345);
        set.add(456);
        set.add(567);
        set.add(678);

        for (Object o :set
             ) {
            System.out.println(o);
        }
    }
}
