package demo1.other;

/**
 * @author: zhanghao
 * @date: 2021/9/11-18:34
 */

import demo1.java.Person;

/**
 * @Description super 关键字 表示父类的，包括多层继承
 * -super 调用父类的属性，属性一般私有，不常用
 * -super 调用父类方法
 *          如果方法没有重写，则可忽略super
 *          如果方法重写，则默认调用此类，super显式调用父类
 * -super 调用构造器
 *          形式为super(...)
 *          如果不写，则默认调用父类无参的构造函数
 *          同this调用构造器，只能放在首行，故同一构造器中super this只能二选一
 */
public class Worker extends Person {

    public int id;

    public Worker(String name, String sex, int age, int id) {
        super(name, sex, age);
        this.id = id;
    }

    @Override
    public Object eat() {
        return super.eat();
    }
}
