package diy;

/**
 * @author: zhanghao
 * @date: 2021/10/9-13:16
 */

/**
 * @Description
 */
public class SubClass<T> extends MyGI<T> {

    public void show() {
        T t = getT();
        System.out.println(t);
    }
}
