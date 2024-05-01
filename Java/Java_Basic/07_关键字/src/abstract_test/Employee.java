package abstract_test;

/**
 * @author: zhanghao
 * @date: 2021/9/15-19:43
 */

/**
 * @Description abstract关键字
 *  -修饰类
 *      作用：用于父类无法确定的子类一些具体化的结构
 *  ①声明为抽象类不能实例化
 *  ②抽象类中不一定有抽象方法，但有抽象方法的一定是抽象类
 *  ③抽象类一般是要被继承的
 *
 *  -修饰方法
 *  ①没有方法体
 *  ②不能修饰构造器，静态方法，final关键字
 *  ③在非抽象类的子类中必须全部被重写
 */
public abstract class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public Employee(){}

    public abstract void work();
//    public void work(){
//
//    }
}
