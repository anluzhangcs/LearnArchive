package enumclass;

/**
 * @author: zhanghao
 * @date: 2021/10/1-21:46
 */

/**
 * @Description
 */
public class EnumTest2 {
    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
//        System.out.println(spring.getClass().getSuperclass());

        //toString()    返回对象常量名
        System.out.println(spring.toString());

        //values()      返回所有枚举类对象的数组
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }

        //valueof(String objName) 返回常量名为objName的枚举类对象
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        winter.show();
    }
}

interface info {
    void show();
}

enum Season1 implements info {
    //1.必须把枚举类对象的提供放在最前面,且对象之间用,隔开 必须省去声明和构造器
    SPRING("Spring", "春暖花开"){
        @Override
        public void show() {
            System.out.println("这是春天");
        }
    },
    SUMMER("Summer", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("这是夏天");
        }
    },
    AUTOMU("Automu", "秋高气爽"){
        @Override
        public void show() {

            System.out.println("这是秋天");
        }
    },
    WINTER("Winter", "凛冬将至"){
        @Override
        public void show() {
            System.out.println("这是冬天");
        }
    };

    //因为枚举类为常量,所以它的属性也应该是常量
    private final String name;
    private final String desc;

    //2.私有化构造方法
    private Season1(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    //提供属性的get        (可选)
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }

    //重写toString()方法        (可选)
    //若不重写 默认调用Enum类的toString输出枚举类常量名
//    @Override
//    public String toString() {
//        return "Season{" +
//                "name='" + name + '\'' +
//                ", desc='" + desc + '\'' +
//                '}';
//    }
}
