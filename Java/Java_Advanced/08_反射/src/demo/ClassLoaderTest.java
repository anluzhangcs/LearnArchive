package demo;

/**
 * @author: zhanghao
 * @date: 2021/10/19-9:59
 */

import com.sun.org.glassfish.gmbal.Description;
import org.junit.Test;


import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

/**
 * @Description 类的加载过程
 *  ①load:通过类的加载器将class文件加载到内存的方法区中,
 *      并在堆中创建一个对应的Class实例,通过Class实例访问方法区中类的数据
 *  ClassLoader:
 *      引导类加载器:用来加载Java核心类库的,如String;不能加载自定义类
 *                  用户获取不到核心类加载器
 *      扩展类加载器:负责jre/lib/ext目录下的jar包或 – D java.ext.dirs 指定目录下的jar包装入工作库
 *      系统加载器:最常用加载器,加载java classpath目录下的类,如自定义类
 *
 *
 *  ②link:将类的二进制数据合并到jre中,对类变量进行默认初始化
 *  ③initialize:JVM对类进行初始化
 *      执行类构造器<clinit>()方法的过程。类构造器<clinit>()方法是由编译期自动收集类中
 *      所有类变量的赋值动作和静态代码块中的语句合并产生的。（类构造器是构造类信
 *      息的，不是构造该类对象的构造器）。
 */
public class ClassLoaderTest {

    @Test
    public void test1() throws Exception {
        //ClassLoaderTest.class就是一个Class实例,通过getClassLoader()获取它的类加载器
        ClassLoader loader1 = ClassLoaderTest.class.getClassLoader();
        System.out.println(loader1); //AppClassLoader
        Class<?> clazz = loader1.loadClass("java.lang.String");
        System.out.println(clazz);

        ClassLoader loader2 = loader1.getParent();
        System.out.println(loader2); //ExtClassLoader

        ClassLoader loader3 = loader2.getParent();
        ClassLoader loader4 = String.class.getClassLoader();
        System.out.println(loader3); //null
        System.out.println(loader4); //null
    }

    @Test
//    读取配置文件的两种方式
    public void test2() throws Exception {
        Properties pros = new Properties();

        //1.通过FileInputStream
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis); //加载输入流
//        System.out.println(pros.getProperty("Driver"));
//        System.out.println(pros.getProperty("url"));


        //2.通过类的加载器,注意配置文件要在src目录下,否则会读取不到,is为null
        //可以理解为ClassLoader在要classpath下使用
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        //以流的方式获取资源
        InputStream is = loader.getResourceAsStream("jdbc.properties");
        pros.load(is);
        System.out.println(pros.getProperty("Driver"));
        System.out.println(pros.getProperty("url"));
    }

    @Test
    /*
     * @Description  创建运行时类的对象
     *  newInstance()方法
     *      -要求类必须有空参构造器
     *      -空参构造器的访问权限必须够,一般设置为public
     *  ==>Java Bean对象必须要有空参的public构造器,因为一般要通过反射来创建
     *      Bean对象
     */
    public void test3() throws Exception {

        Class<Person> clazz = Person.class;
//        Class<?> aClass = Class.forName("java.lang.String");
        Person person = clazz.newInstance();
        System.out.println(person);

    }

    @Test
    //反射的动态性体现
    public void test4() {

        for (int i = 0; i < 100; i++) {
            //生成0,1,2的随机数
            int num = new Random().nextInt(3);
            String className ="";

            switch (num) {
                case 0:
                    className = "java.lang.Object";
                    break;
                case 1:
                    className = "java.util.Date";
                    break;
                case 2:
                    className = "demo.Person";
                    break;
            }
            try {
                Object o = getInstance(className);
                System.out.println(o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object getInstance(String className) throws Exception {
        Class clazz = Class.forName(className);
        Object o = clazz.newInstance();
        return o;
    }
}
