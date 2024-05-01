package proxy;

/**
 * @author: zhanghao
 * @date: 2021/10/20-14:12
 */

/**
 * @Description 静态代理的测试
 *  代理设置模式:
 *      实现同一个接口的被代理类和代理类,代理类创建是需要传一个被代理类实例
 *      这样代理类调用接口方法时,代理类方法中调用被代理类对象的同名方法,实现代理
 *   所谓代理,就是通过实现相同功能接口的其他类调用被代理类的方法,不用被代理类亲自调
 *
 *   缺陷:编译期间就确定了代理类和被代理类,当需要多个接口,可能需要多个代理类
 */

interface ClothFactory{
    void produceColth();
}

//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceColth() {
        System.out.println("代理类做一些准备工作");
        clothFactory.produceColth();
        System.out.println("代理类做一些收尾工作");
    }
}

//被代理类
class NikeFactory implements ClothFactory{

    @Override
    public void produceColth() {
        System.out.println("Nike生产一批空军一号");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        NikeFactory nike = new NikeFactory();
        ProxyClothFactory proxy = new ProxyClothFactory(nike);
        proxy.produceColth();
    }
}
