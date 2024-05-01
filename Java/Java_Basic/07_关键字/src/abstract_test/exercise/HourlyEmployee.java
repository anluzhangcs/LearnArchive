package abstract_test.exercise;

/**
 * @author: zhanghao
 * @date: 2021/9/16-9:50
 */

import java.util.Date;

/**
 * @Description
 */
public class HourlyEmployee extends Employee {
    private double wage;
    private double hour;

    public HourlyEmployee(int id, String name, MyDate date, double wage, double hour) {
        super(id, name, date);
        this.wage = wage;
        this.hour = hour;
    }

    @Override
    public double earnings() {
        Date now = new Date();
        if (getDate().getMonth()==now.getMonth())
            return wage * hour + 100;
        else
            return wage * hour;
    }

}
