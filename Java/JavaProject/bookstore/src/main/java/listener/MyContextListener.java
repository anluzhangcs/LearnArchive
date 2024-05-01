package listener;

/**
 * @author: zhanghao
 * @date: 2021/11/2-22:11
 */

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Description
 */
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("web程序启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("web程序销毁");
        try {
            while(DriverManager.getDrivers().hasMoreElements()) {
                DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
            }
            AbandonedConnectionCleanupThread.checkedShutdown();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
