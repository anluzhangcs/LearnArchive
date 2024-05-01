package bean;

/**
 * @author: zhanghao
 * @date: 2021/11/8-20:32
 */

/**
 * @Description
 */
public class Person {
    private String username;
    private int age;

    public Person() {
    }

    public Person(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
