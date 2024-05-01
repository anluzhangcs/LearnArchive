package demo;

/**
 * @author: zhanghao
 * @date: 2021/10/18-15:22
 */

/**
 * @Description
 */
public class Person {
    private String name;
    public int age;
    int id;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    private Person(int age) {
        this.age = age;
    }

    public static void show() {
        System.out.println("我是一个人");
    }

    private String showNation(String nation) {
        System.out.println(nation);
        return nation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
