package abstract_test.exercise;

/**
 * @author: zhanghao
 * @date: 2021/9/16-9:30
 */

import java.util.Date;

/**
 * @Description
 */
public class SalariedEmployee extends Employee{
    private double monthlySalary;

    public SalariedEmployee(int id, String name, MyDate date, double monthlySalary) {
        super(id, name, date);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double earnings() {
        Date now = new Date();
        if (getDate().getMonth()==now.getMonth()+1 )
            return monthlySalary+100;
        else
            return monthlySalary;
    }

}
