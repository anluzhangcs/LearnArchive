package org.zhang.bean;

/**
 * @author: zhanghao
 * @date: 2021/11/22-15:52
 */

/**
 * @Description
 */
public class User {

    private String name;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

        public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("Hello Spring...");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
