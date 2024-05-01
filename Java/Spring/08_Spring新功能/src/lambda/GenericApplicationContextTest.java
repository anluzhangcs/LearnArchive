package lambda;

/**
 * @author: zhanghao
 * @date: 2021/12/1-11:53
 */

import org.springframework.context.support.GenericApplicationContext;

/**
 * @Description 通过GenericApplicationContext将new的对象交给Spring核心容器管理
 */
public class GenericApplicationContextTest {

    public static void main(String[] args) {
        //通过GenericApplicationContext类实现
        GenericApplicationContext context = new GenericApplicationContext();
        //清楚容器中对象
        context.refresh();
        //将对象注册到容器中
        context.registerBean("user",User.class,User::new);
        //从容器中获取对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
