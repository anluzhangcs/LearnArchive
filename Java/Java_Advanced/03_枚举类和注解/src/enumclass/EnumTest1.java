package enumclass;

/**
 * @author: zhanghao
 * @date: 2021/10/1-21:35
 */

/**
 * @Description 枚举类的使用
 *  -枚举类特性:
 *      ①类的对象是有限的,确定的
 *      ②枚举类对象都是常量,不能改变
 *  -创建枚举类
 *      -自定义枚举类         ----------jdk1.5之前
 *      -enum关键字创建       ----------jkd1.5引入
 *          所有用enum关键字声明的枚举类都会继承java.lang.Enum
 */
public class EnumTest1 {
    public static void main(String[] args) {
        Season winter = Season.WINTER;
        System.out.println(winter);
    }
}


class Season {
    //因为枚举类为常量,所以它的属性也应该是常量
    private final String name;
    private final String desc;

    //1.私有化构造方法
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    //2.创建枚举对象.声明为public static final
    public static final Season SPRING = new Season("Spring", "春暖花开");
    public static final Season SUMMER = new Season("Summer", "夏日炎炎");
    public static final Season AUTOMU = new Season("Automu", "秋高气爽");
    public static final Season WINTER = new Season("Winter", "凛冬将至");

    //提供属性的get        (可选)
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    //重写toString()方法        (可选)

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

