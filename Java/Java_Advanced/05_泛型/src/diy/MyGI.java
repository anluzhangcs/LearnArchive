package diy;

/**
 * @author: zhanghao
 * @date: 2021/10/9-13:02
 */

/**
 * @Description 自定义泛型类,泛型接口
 *  -在声明类时用<>表示泛型,可以用大写字母表示,一般用T(type),E(element),K,V
 *  -类的构造器还是public xxx(){},不需要带泛型.在实例化时会若指明泛型则构造器也会自动指定
 *  -创建类对象时,若没有指定泛型,就相当于T为Object(不推荐,使用泛型就要指明泛型)
 *  -类的静态方法中不能使用泛型.静态方法随类的加载而加载,而泛型是创建对象时才指定的
 *  -继承泛型类<T>时:
 *      ①若没有指定泛型,就相当于擦除泛型-->子类还是一个普通类
 *      ②若指定泛型,则父类确定         -->子类为普通类
 *      ③若没有指定泛型,子类也有泛型.则子类必须有父类的泛型<T> -->子类为泛型类
 *  -异常类不能使用泛型
 *  -泛型不同的引用不能相互赋值
 */
public class MyGI<T> {
    private String name;
    private int age;

    //若类中有不确定的结构,就可以用泛型
    private T t;

    public MyGI() {
    }

    public MyGI(String name, int age, T t) {
        this.name = name;
        this.age = age;
        this.t = t;
    }

    public void show() {
        //static报错
        System.out.println(t);
    }

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
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

    @Override
    public String toString() {
        return "MyGI{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", t=" + t +
                '}';
    }
}
