package org.zhang.autowire;

/**
 * @author: zhanghao
 * @date: 2021/11/23-20:44
 */


/**
 * @Description
 */
public class Employee {
    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "dept=" + dept +
                '}';
    }
}
