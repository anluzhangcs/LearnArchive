package org.zhang.bean;

/**
 * @author: zhanghao
 * @date: 2021/11/22-21:14
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description 测试注入复杂数据类型.数组, list, set, map等
 */
public class Student {

    private String[] arr;
    private List<String> list;
    private Set<Course> set;
    private Map<String, Integer> map;

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<Course> set) {
        this.set = set;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Student{" +
                "arr=" + Arrays.toString(arr) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                '}';
    }
}
