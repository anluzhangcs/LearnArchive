package demo1.java;

/**
 * @author: zhanghao
 * @date: 2021/10/11-10:48
 */

/**
 * @Description
 */
public class Person {
    private String name;
    private int age;

    public Person() {
        System.out.println("Person被创建了");
    }

    //此时Person并没有被创建,person为实例成员,存放在堆中,jvm先加载了方法区的类定义
    //在main方法实例化时,会无限循环造成栈溢出
//     Person person = new Person();

    //person为类成员,存放在方法区中,jvm加载了方法区的类定义时被创建
    //因为静态成员只会被加载一次,所以不会栈溢出
//    static Person person = new Person();

//    public  Person getPerson() {
//        return person;
//    }

    public static void main(String[] args) {
//        new Person();
    }
}
