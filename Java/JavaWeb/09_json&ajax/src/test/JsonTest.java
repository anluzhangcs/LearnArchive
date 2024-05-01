package test;

/**
 * @author: zhanghao
 * @date: 2021/11/8-20:34
 */

import bean.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.org.apache.bcel.internal.generic.GOTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description JSON的使用-对象,List,Map和JSON字符串之间的相互转换
 */
public class JsonTest {

    /*
     * @Description  JavaBean <==> JSON字符串
     * @param
     * @return  void
     */
    @Test
    public void test1() {
        Person person = new Person("张三", 21);

        //创建Gson对象,相当于一个用于互相转换的工具类
        Gson gson = new Gson();

        //调用toJson方法将JavaBean转换为json字符串
        String jsonString = gson.toJson(person);
        System.out.println(jsonString);

        //调用fromJson将json字符串转换为JavaBean对象
        //第一个参数为json字符串
        //第二个参数为JavaBean对象类型
        Person person1 = gson.fromJson(jsonString, Person.class);
        System.out.println(person1);
    }

    @Test
    public void test2() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("张三", 21));
        list.add(new Person("李四", 20));

        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);

        //对于List和Map类型,转换时的类型需要特殊定义
        //要继承Gson包提供的TypeToken<>类,里面的泛型为要转换的数据类型,然后获取Type
        List<Person> list2 = gson.fromJson(json, new TypeToken<List<Person>>() {
        }.getType());
        System.out.println(list2);
        System.out.println(list2.get(1));

    }

    @Test
    public void test3() {
        Map<Integer, Person> map = new HashMap<>();
        map.put(1, new Person("张三", 21));
        map.put(2, new Person("李四", 20));

        Gson gson = new Gson();

        String s = gson.toJson(map);
        System.out.println(s);

        Map<Integer,Person> map2 = gson.fromJson(s, new TypeToken<Map<Integer, Person>>() {
        }.getType());
        System.out.println(map2);
        Person person = map2.get(1);
        System.out.println(person);
    }


}
