package bean;

/**
 * @author: zhanghao
 * @date: 2021/11/1-20:19
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Description
 */
public class Person {
    private String name;
    private int age;
    private String[] phones;
    private List<String> list;
    private Map<String, Integer> map;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phones=" + Arrays.toString(phones) +
                ", list=" + list +
                ", map=" + map +
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

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public Person(String name, int age, String[] phones, List<String> list, Map<String, Integer> map) {
        this.name = name;
        this.age = age;
        this.phones = phones;
        this.list = list;
        this.map = map;
    }

    public Person() {

    }
}
