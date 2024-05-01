package domain;

/**
 * @author: zhanghao
 * @date: 2021/9/19-18:33
 */

/**
 * @Description
 */
public class Designer extends Employee{
    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary, "设计师", 5000, 0, equipment);
    }
}
