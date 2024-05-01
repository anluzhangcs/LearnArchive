package abstract_test.exercise;

/**
 * @author: zhanghao
 * @date: 2021/9/16-9:22
 */

/**
 * @Description
 */
public abstract class Employee {
    private int id;
    private String name;
    private MyDate date;

    @Override
    public String toString() {
        return
                "工号：" + id +
                "\n姓名：" + name +
                "\n生日：" + date+
                "\n工资" + earnings();
    }

    public Employee(){

    }

    public Employee(int id, String name, MyDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public MyDate getDate() {
        return date;
    }

    public abstract double earnings();
}
