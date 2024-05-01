package demo1.java;

/**
 * @author: zhanghao
 * @date: 2021/9/11-18:30
 */

/**
 * @Description
 */
public class Person {
    private String name;
    private String sex;
    private int age;
    private int id;

    public Person() {
    }

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void eat(){
        System.out.println("基本吃饭");
    }

    public void sleep(){
        System.out.println("基本睡觉");
    }
}
