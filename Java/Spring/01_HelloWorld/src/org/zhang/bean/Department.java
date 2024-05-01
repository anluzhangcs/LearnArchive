package org.zhang.bean;

/**
 * @author: zhanghao
 * @date: 2021/11/22-20:18
 */

/**
 * @Description
 */
public class Department {

    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

//    public String getDname() {
//        return dname;
//    }

    @Override
    public String toString() {
        return "Department{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
