package org.zhang.bean;

/**
 * @author: zhanghao
 * @date: 2021/11/22-20:19
 */

/**
 * @Description
 */
public class Employee {
    private String ename;
    private String gender;
    private Department dept;

    public Department getDept() {
        return dept;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ename='" + ename + '\'' +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }
}
