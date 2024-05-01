package abstract_test;

/**
 * @author: zhanghao
 * @date: 2021/9/15-19:59
 */

/**
 * @Description
 */
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public Manager(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("Manager manage the company");
    }
}
