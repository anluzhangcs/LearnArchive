package io;

/**
 * @author: zhanghao
 * @date: 2021/10/13-14:42
 */

import org.junit.Test;

import java.io.*;

/**
 * @Description 对象流的使用
 *  ObjectInputStream :将二进制流转为为对象,反序列化过程
 *  ObjectOutputStream:将对象序列化为二进制流,序列化过程
 *
 *  序列化机制:Java将可序列化的对象转换为二进制保存在文件中或者通过网络传输.
 *  在有需求的情况下,将其进行反序列化又变成Java对象
 *
 *  对象流和数据流的异同:
 *  -数据流写入基本数据类型和String
 *  -对象流既可以写基本数据类型,还可以写入对象
 *  -二者写入的数据都不是用来读的
 *  -二者写入和读写的顺序必须要一致,否则会乱码
 */
public class ObjectStreamTest {

    @Test
    //对象流的序列化
    public void test1() {
        ObjectOutputStream oos = null;
        try {
            //1.创建对象流
            //注:对象流写入的数据是不可读的,就是不是用来读的,可以保存为.dat文件
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));

            //2.写入操作
            oos.writeObject(new String("张三"));
            oos.writeObject(new Person("王五", 23, "male"));
            oos.writeObject(new Person("李四", 25, "female", new Account(5000)));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关流
            if (oos != null) {

                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    //对象的反序列化
    public void test2() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object o = ois.readObject();
            Person person1 = (Person) ois.readObject();
            Person person2 = (Person) ois.readObject();

            String str = (String) o;
            System.out.println(str);
            System.out.println(person1);
            System.out.println(person2);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {

                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test3() {


    }
}

/*
 * @Description  保证对象可以被序列化 ①~③缺一不可
 *  ①实现序列化标识接口
 *  ②定义全局常量serialVersionUID xxx static final long serialVersionUID
 *      serialVersionUID作用:保证对象反序列化时找不到类出错
 *          唯一表示一个类,如果不声明,Java会根据类的内部细节自动生成,因此它是可以改变的
 *          如果将对象序列化后改变这个类,那么类的serialVersionUID就会改变
 *          就会导致反序列化时会出错
 *  ③对象的所有属性也要是序列化的(基本数据类型默认序列化,String也可以序列化)
 *
 *  注:如果变量被static或者transient关键字修饰,则不会被序列化
 */

class Person implements Serializable { //实现序列化标识接口,指明实现这个接口的都是可序列化的类

    //serialVersionUID序列化版本UID,是必须的,也是唯一的
    private static final long serialVersionUID = 228472938532L;

    private String name;
    private int age;
    private transient String sex;
    private static Account account;

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name, int age, String sex, Account account) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", account=" + account +
                '}';
    }
}

class Account implements Serializable{

    private static final long serialVersionUID = 247320524395l;

    private double balance;

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }

    public Account(double balance) {
        this.balance = balance;
    }
}