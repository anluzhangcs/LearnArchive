package proxyTemplate;

/**
 * @author: zhanghao
 * @date: 2021/9/17-16:21
 */

/**
 * @Description 经纪人
 */
public class Proxy implements Star{
    private Star star;

    public Proxy(Star star) {
        this.star = star;
    }

    @Override
    public void sing() {
        star.sing();
    }

    @Override
    public void bookTicket() {
        System.out.println("订票是经纪人做的");
    }

    @Override
    public void signConfer() {
        System.out.println("签合同是经纪人做的");
    }
}
