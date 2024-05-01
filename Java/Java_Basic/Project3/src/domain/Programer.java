package domain;

/**
 * @author: zhanghao
 * @date: 2021/9/19-17:29
 */

/**
 * @Description
 */
public class Programer extends Employee {
    public Programer() {
    }

    public Programer(int id, String name, int age, double salary,Equipment equipment) {
        super(id, name, age, salary, "程序员", 0, 0, equipment);

    }
}
