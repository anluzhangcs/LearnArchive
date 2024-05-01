package org.zhang.proxy;

/**
 * @author: zhanghao
 * @date: 2021/11/25-11:30
 */



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 */

//创建代理类的工厂
public class ProxyFactory {

    /*
     * @Description  获取代理类对象
     * @param object 为传入的被代理类对象
     * @return  返回实现接口的代理类对象
     */
    public static Object getProxyInstance(Object object) {

        //调用Proxy的静态方法
        //第一个参数为类的加载器.一般类都是系统加载器加载
        //第二个参数为被代理类对象实现的接口
        //第三个参数为处理类对象
        return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), object.getClass().getInterfaces(), new MyHandler(object));

    }

}

class MyHandler implements InvocationHandler{

    //被代理类对象
    private Object obj;

    //传入被代理对象.可以通过方法,也可以使用构造器
    public MyHandler(Object obj) {
        this.obj = obj;
    }


    /*
     * @Description  invoke方法即为增强逻辑的方法
     * @param proxy 表示代理类对象
     * @param method 表示要增强的方法
     * @param args 表示方法参数
     * @return  java.lang.Object,返回值即为原方法的返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行之前增强的逻辑");

        Object res = method.invoke(obj, args);

        System.out.println("执行之后增强的逻辑");

        //返回原方法的返回值
        return res;
    }
}
