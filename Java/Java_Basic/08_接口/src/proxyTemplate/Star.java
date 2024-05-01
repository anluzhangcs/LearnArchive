package proxyTemplate;

/**
 * @author: zhanghao
 * @date: 2021/9/17-16:16
 */

/**
 * @Description Proxy代理模式
 *
 * 将对象实际要做的事抽象为接口,代理对象去实现这些接口,被代理对象在幕后被隐藏起来,
 * 而表示出来还是被代理对象做的
 */

//明星
public interface Star {
    void sing();
    void bookTicket();
    void signConfer();
}
