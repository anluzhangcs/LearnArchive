package diy;

/**
 * @author: zhanghao
 * @date: 2021/10/9-20:06
 */

/**
 * @Description 自定义泛型方法
 *
 */
public class Person<T> {

    private String name;
    private int age;
    private T info;

    //
    /*
     * @Description  自定义泛型方法
     * 格式:
     *    访问权限修饰符 泛型 返回类型 方法名(){}
     * 注意:
     *    -权限修饰符后面要加上<E>,负责会认为E是一个类报错
     *    -泛型方法与类是不是支持泛型的无关
     */
    public <E> void show(E e) {
//        E e1 = ;
        System.out.println(e);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", info=" + info +
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

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Person() {

    }

    public Person(String name, int age, T info) {

        this.name = name;
        this.age = age;
        this.info = info;
    }
}
