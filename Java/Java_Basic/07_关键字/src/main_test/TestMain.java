package main_test;

/**
 * @author: zhanghao
 * @date: 2021/9/13-11:18
 */

/**
 * @Description main方法的使用
 *  -java是纯对象编程，main方法也在类中，并可以调用这个类的其它static方法或属性,
 *      如果是非静态的，可以通过创建对象然后调用
 *  -main方法也可以创建这个类的对象，main方法使用时，类已经被加载到了内存，这样就可以创建对象了
 *  -main方法是程序的入口，不需要对象就可以调用，也可以通过对象调用其他类的main方法
 */
public class TestMain {
    public static int i = 3;
    public int i1=4;

    public static void main(String[] args) {

        show();
        TestMain testMain = new TestMain();
        testMain.show3();
    }

    public static void show(){
        System.out.println(i);
    }
    public void show3(){
        System.out.println(i1);
    }
}
