package org.zhang.bean;

/**
 * @author: zhanghao
 * @date: 2021/11/22-17:48
 */

/**
 * @Description 基于构造器注入属性
 */
public class Student {
    private String name;
    private String sex;

    public Student(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
