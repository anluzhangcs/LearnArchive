package proxyTemplate;

/**
 * @author: zhanghao
 * @date: 2021/9/17-16:25
 */

/**
 * @Description
 */
public class RealStar implements Star{
    @Override
    public void sing() {
        System.out.println("这是歌手自己唱的");
    }

    @Override
    public void bookTicket() {

    }

    @Override
    public void signConfer() {

    }
}
