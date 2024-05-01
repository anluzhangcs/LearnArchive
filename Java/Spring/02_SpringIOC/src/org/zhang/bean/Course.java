package org.zhang.bean;

/**
 * @author: zhanghao
 * @date: 2021/11/22-21:20
 */

/**
 * @Description
 */
public class Course {
    private String cname;

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
