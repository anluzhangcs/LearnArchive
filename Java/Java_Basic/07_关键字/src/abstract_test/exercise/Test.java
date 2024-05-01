package abstract_test.exercise;

/**
 * @author: zhanghao
 * @date: 2021/9/16-9:19
 */

/**
 * @Description 抽象练习测试
 */
public class Test {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++) {
            if (i%2 == 0){
                employees[i] = new SalariedEmployee(i+1,"employee"+i,new MyDate(2001,i+1,21),5000);
                System.out.println(employees[i]);
            } else{
                employees[i] = new HourlyEmployee(i+1,"employee"+i,new MyDate(2001,i+1,21),80,8);
                System.out.println(employees[i]);
            }
        }
    }
}
