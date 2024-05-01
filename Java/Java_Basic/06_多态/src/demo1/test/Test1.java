package demo1.test;

/**
 * @author: zhanghao
 * @date: 2021/9/12-8:57
 */

import demo1.java.Person;
import demo1.java.Student;
import demo1.java.Worker;

/**
 * @Description
 */
public class Test1 {
    public static void main(String[] args) {

        /*
         * 虚拟方法
         * -父类中被子类重写的方法叫做虚拟方法
         * 将父类的引用指向子类的对象，通过引用来调用子类的属性和方法
         * 编译时：编译器认为调用的就是父类的方法
         * 运行时：才明确调用哪个具体子类对象的重写方法
         *
         */
        Person p1 = new Student();
        Person p2 = new Worker();
        p1.eat();
//        p1.study();
//        p1.id;
//        p2.id;
        /*
         * 向下转型：强制类型转换
         * 作用：
         *     -解决不能调用子类特有的属性和方法
         * instanceOf 关键字：
         *     -格式： a instanceof A
         *     -作用：判断a是否能指向A的实例
         *     -返回值：Boolean
         */
//        Student stu = (Student) p1;
        if (p1 instanceof Student){
            System.out.println("nihao");
        }
    }
}
