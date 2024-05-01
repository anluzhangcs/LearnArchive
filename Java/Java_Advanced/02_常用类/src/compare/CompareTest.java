package compare;

/**
 * @author: zhanghao
 * @date: 2021/10/1-17:22
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description 比较类的大小
 *  -String,包装类等已经实现类Comparable接口
 *  -java比较器默认 1表示大于,0表示等于,-1表示小于
 *  -比较方式
 *      实现Comparble接口,实现compareTo(obj)方法,自然比较
 *      利用实现Comparator接口的类,实现compare(obj1,obj2)定制比较,一般为临时性.
 *  -Java比较器的应用
 *      Arrays.sort(arr)    使用自然比较排序,默认从小到大
 *      Arrays.sort(arr,new Comparator(){}) 使用定制比较排序
 *
 */
public class CompareTest {

    @Test
    public void test3() {
        Goods[] goods = new Goods[4];
        goods[0] = new Goods("levono", 34);
        goods[1] = new Goods("mi", 40);
        goods[2] = new Goods("apple", 90);
        goods[4] = new Goods("appo", 50);
        //实现按名称从小到大排序,价格从大到小排序
        Arrays.sort(goods,new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if (g1.getName().equals(g2.getName())) {
                        //包装类中的静态方法compare
                        return Double.compare(g1.getPrice(), g2.getPrice());
                    } else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("数据类型不一致");
            }
        });
    }

    @Test
    public void test2() {
        Goods[] goods = new Goods[3];
        goods[0] = new Goods("levono", 34);
        goods[1] = new Goods("mi", 40);
        goods[2] = new Goods("apple", 90);
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));

    }

    @Test
    public void test1() {
        String[] arr = new String[]{"AA", "KK", "DD", "CC"};
        //sort()方法内部使用了排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
