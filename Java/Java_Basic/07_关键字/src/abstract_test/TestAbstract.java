package abstract_test;

/**
 * @author: zhanghao
 * @date: 2021/9/15-19:36
 */

/**
 * @Description 测试抽象类
 */
public class TestAbstract {
    public static void main(String[] args) {
        Employee employee = new Manager(2000);
        employee.work();
        //抽象类的匿名子类，一般匿名的类或对象都是用来临时使用一次的
        method1(new Employee() {
            @Override
            public void work() {

            }
        });
    }

    public static void method1(Employee employee){
        System.out.println("类的匿名子类");
    }
}
