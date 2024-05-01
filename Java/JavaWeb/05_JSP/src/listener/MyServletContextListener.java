package listener;

/**
 * @author: zhanghao
 * @date: 2021/11/1-19:18
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Description 创建ServletContext监听器
 */
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext被创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext被销毁了");
    }
}
