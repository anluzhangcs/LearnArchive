package demo;

/**
 * @author: zhanghao
 * @date: 2021/10/18-15:21
 */

import org.junit.Test;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description 反射的简单使用
 *  Reflection API
 *      java.lang.Class
 *      java.lang.Reflect.Constructor
 *      java.lang.Reflect.Method
 *      java.lang.Reflect.Filed
 *      ...
 *
 *  总结:
 *      ①反射就像一面镜子,任何继承Object类的对象都可以通过getClass()方法获取对象的类
 *      ②通过反射可以调用对象的私有内部结构,但使用之前必须setAccessible(true)
 *      ③反射具有动态性
 *      ④反射与封装是不矛盾的.封装是建议我们不要调用不想被直接调用的结构,而反射则是能不能调用
 *
 */
public class ReflectionTest {

    @Test
    //反射没用之前获取对象的内部结构
    public void test1() {
        Person person = new Person();
        person.age = 21;
        person.show();
        System.out.println(person);
    }

    @Test
    //反射用了之后
    public void test2() throws Exception{
        //Person.class 是Class类的一个对象
        Class<Person> clazz = Person.class;
        System.out.println(Person.class);

        //获取Constructor对象并调用newInstance()创建Person的对象
        Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);
        Person person = constructor.newInstance("张三", 21);
        System.out.println(person);

        //获取Field对象并调用set()修改person的变量值
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true); //私有结构要设置可访问
        name.set(person, "李四");
        System.out.println(person);

        //获取Method对象来调用person对象的方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);

        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        //invoke(Object obj,Object ... args)
        //第一个参数表示要invoke哪个对象的方法,第二个可变形参表示方法的参数
        showNation.invoke(person, "中国");
    }


    @Test
    /*
     * @Description  java.lang.Class类
     *  类的加载过程:java.exe执行.class文件,然后.class文件被加载到内存的方法
     *  区中,Class的一个实例就是一个运行的类
     */
    public void test3() throws ClassNotFoundException {
        //获取Class实例
        //1.通过类的.class属性
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        //2.通过对象的getClass()方法
        Person p = new Person();
        Class<? extends Person> clazz2 = p.getClass();
        System.out.println(clazz2);

        //3.通过Class.forName(String className)方法 ==>常用
        Class<?> clazz3 = Class.forName("demo.Person");
        System.out.println(clazz3);

        //4.通过getClassLoader() 不常用
        ClassLoader loader = Person.class.getClassLoader();
        Class<?> clazz4 = loader.loadClass("java.lang.String");
        System.out.println(clazz4);

        //加载到内存的运行时类只会被加载一次,所对应的Class实例也只有一个
        System.out.println(clazz1 == clazz2); //true
        System.out.println(clazz1 == clazz3); //true
        System.out.println(clazz1 == clazz4); //false

    }

    @Test
    //哪些类型可以是Class实例
    public void test4() {
        Class c1 = String.class; //类
        Class c2 = Serializable.class; //接口
        Class c3 = ElementType.class; //enum
        Class c4 = Override.class; //注解
        Class c5 = int.class; //基本数据类型
        Class c6 = void.class; //void
        Class c7 = char[].class; //数组
        Class c8 = Class.class;  //Class本身

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }

    @Test
    //获取运行时类的指定属性
    public void testFiled() throws Exception {
        //1.获取运行时类的Class实例,这是反射的前提
        Class<Person> clazz = Person.class;

        Person person = clazz.newInstance();
        /*
         *  2.获取指定属性
         *   (推荐)   getDeclaredFiled(String filedName) 可获取此类在中所有属性
         *   (不推荐)  getField(String name) 只获取此类及父类中public属性
         *
        */
        Field age = clazz.getDeclaredField("age");

        /*
         * 3.获取或设置属性
         *  get(Object obj) 获取指定对象该属性的值
         *  set(Object obj,Object value) 设置指定对象指定属性的值
         *  注:若set非public属性,在set之前必须设置setAccessible(true)
         *      确保该属性是可以访问的
         */

        Object o = age.get(person);
        System.out.println(o);

        age.setAccessible(true);
        age.set(person, 23);
        System.out.println(person);

    }

    @Test
    public void testMethod() throws Exception {

        //1.获取对应类的Class实例
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();

        /*
         * @Description  2.获取指定方法
         *  getDeclaredMethod(String name,Class<?> ...args)
         *      -参数1,指明方法名
         *      -参数2,可变参数,指明方法的获取方法的形参列表
         */
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);

        //3.确保方法可以访问
        showNation.setAccessible(true);

        /*
         * @Description  4.调用方法
         *  invoke(Object obj,Object ...args)
         *      -参数1:指明调用哪个对象的方法
         *      -参数2:可变参数,指明方法的实参
         *    返回值:invoke返回值即为该方法返回值,若该方法无返回值,则invoke返回null
         *
         */
        //非静态方法
        Object returnVal = showNation.invoke(person, "USA");
        System.out.println(returnVal);

        //静态方法
        Method show = clazz.getDeclaredMethod("show");
        show.setAccessible(true);
//        show.invoke(clazz);  //参数1为类本身,clazz就是这个类
        show.invoke(Person.class); // 类本身
        show.invoke(null);  //也可以为null,因为是类方法,而不是对象方法
    }
}
