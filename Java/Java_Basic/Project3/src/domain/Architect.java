package domain;

/**
 * @author: zhanghao
 * @date: 2021/9/19-18:35
 */

/**
 * @Description
 */
public class Architect extends Employee {
    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary, "架构师", 10000, 2000, equipment);
    }
}
