package exer;

/**
 * @author: zhanghao
 * @date: 2021/10/7-21:09
 */

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Description
 */
public class TreeSetTest {
    public static void main(String[] args) {

        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int res = Integer.compare(o1.getBirthday().getMonth(),o2.getBirthday().getMonth());
                if (res == 0) {
                    return Integer.compare(o1.getBirthday().getDay(), o2.getBirthday().getDay());

                } else
                    return res;

            }
        };

        TreeSet<Employee> set = new TreeSet(comparator);
        set.add(new Employee("tom", 21, new MyDate(2001, 2, 18)));
        set.add(new Employee("tom", 23, new MyDate(2001, 3, 18)));
        set.add(new Employee("jerry", 21, new MyDate(2001, 1, 28)));
        set.add(new Employee("jack", 24, new MyDate(2001, 12, 18)));
        set.add(new Employee("dick", 25, new MyDate(2001, 2, 15)));

        //按姓名排序
        for (Employee e : set) {
            System.out.println(e);
        }
    }
}


class Employee implements Comparable{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;

        this.birthday = birthday;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee) {
            Employee e = (Employee) o;
            return this.name.compareTo(e.name);
        } else{
            throw new RuntimeException("类型不匹配");
        }
    }
}

class MyDate{
    private int year;

    private int month;

    private int day;
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}