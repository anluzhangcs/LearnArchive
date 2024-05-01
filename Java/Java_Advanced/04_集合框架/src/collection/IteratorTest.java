package collection;

/**
 * @author: zhanghao
 * @date: 2021/10/2-21:22
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Description Iterator迭代器遍历容器中的元素
 *  -Collection接口实现类Iterator接口,故Collection的所有子接口及其实现类都可以使用Iterator
 *  -Collection对象通过iterator()方法获得一个Iterator对象
 *  -Iterator通过指针指向Collection对象
 *  -hasNext()方法判断是否有下一个元素
 *  -next()方法先指针下移,然后返回指针指向的元素
 */
public class IteratorTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("Tom");
        coll.add(new Person("Jerry", 21));
        coll.add(false);

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
