package org.zhang.autowire;

/**
 * @author: zhanghao
 * @date: 2021/11/23-20:44
 */

/**
 * @Description
 */
public class Dept {
    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
