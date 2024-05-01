package block;

/**
 * @author: zhanghao
 * @date: 2021/9/14-13:02
 */

/**
 * @Description 代码块
 *  -代码块如果用关键字修饰，只能用static
 *  -代码块不需要类或者对象调用，自己执行,与方法不同
 *  -分类：
 *      ①静态代码块：static{}
 *          -随着类的加载而加载
 *          -只能调用静态属性或方法
 *          -可以用于初始化类的信息
 *      ②非静态代码块：{}
 *          -随着对象的创建而加载
 *          -可以调用静态或非静态的
 *          -同样可以初始化对象的信息
 */
public class Person {
    private String name="zhangsan";
    private int age=2;


    private static String desc="wo shi yi ge ren-2";

    {
        desc = "wo shi yi ge ren-1";
    }
    static {
        desc = "wo shi yi ge ren-3";
    }

    {
        age = 18;
        name = "zhangsan";
    }

    public Person(){
        age = 20;
        name = "lisi";
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static String getDesc() {
        return desc;
    }
}
