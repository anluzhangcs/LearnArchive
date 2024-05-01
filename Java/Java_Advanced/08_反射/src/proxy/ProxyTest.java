package proxy;

/**
 * @author: zhanghao
 * @date: 2021/10/20-14:56
 */


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description 动态代理
 *  根据被代理类对象动态的生成代理类,并通过代理类调用被代理类对象方法
 *  这样只需要一个代理类工厂,就可以动态生成代理类对象
 *
 *  总结:首先,需要一个ProxyFactory代理类生成工厂.工厂中有获取代理类对象
 *  的静态方法,通过ProxyFactory直接调用.方法参数为被代理类对象,返回值为代理类对象,
 *  方法体为Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
 *  loader为传入代理类对象的类加载器,interfaces为传入代理类对象的实现接口,handler需要一个实现
 *  InvocationHandler接口的类,在类中对代理类对象进行绑定,并重写invoke方法.
 */

interface Human{
    void eat(String food);

    String info();
}

//被代理类
class SuperMan implements Human{

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }

    @Override
    public String info() {
        return "我是超人";
    }
}




class MyHandler implements InvocationHandler{

    private Object obj; //被代理类对象

    public void bind(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnVal = method.invoke(obj, args);
        return returnVal;
    }
}

//代理类工厂
class ProxyFactory{


    //获取代理类对象方法,参数obj就是要传入的被代理类对象

    public static Object getProxyInsatnce(Object obj) {
        //handler实现调用被代理类的方法
        MyHandler handler = new MyHandler();
        handler.bind(obj); //传入被代理类对象绑定

        /*
         * Proxy.newProxyInstance是java.lang.reflect.Proxy提供的方法,返回代理类对象
         *  参数1:被代理类的类加载器
         *  参数2:被代理类的实现接口
         *  参数3:通过它来调用被代理类的方法
         *
         */
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }

}

public class ProxyTest {
    public static void main(String[] args) {

        //1.创建被代理类
        SuperMan superMan = new SuperMan();

        //2.通过ProxyFactory动态创建代理类
        Human proxyInsatnce = (Human) ProxyFactory.getProxyInsatnce(superMan);

        //3.通过代理类调用方法
        proxyInsatnce.eat("米粉");
        String info = proxyInsatnce.info();
        System.out.println(info);

        System.out.println("*******动态代理********");
        NikeFactory nikeFactory = new NikeFactory();
        ClothFactory proxyInsatnce1 = (ClothFactory) ProxyFactory.getProxyInsatnce(nikeFactory);
        proxyInsatnce1.produceColth();

    }
}
