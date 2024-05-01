package proxyTemplate;

/**
 * @author: zhanghao
 * @date: 2021/9/17-16:30
 */

/**
 * @Description
 */
public class Test {
    public static void main(String[] args) {

        /*
         * new RealStar(),一个真的明星,很少露面,将他一些要做的是交给经纪人
         * proxy 经纪人做一些他能做的是,如订票
         *      经纪人不能做的事还是明星去做,如唱歌,只是是经纪人叫他去唱歌
         */
        Proxy proxy = new Proxy(new RealStar());
        proxy.sing();
        proxy.bookTicket();
        proxy.signConfer();
    }
}
