package utils;

/**
 * @author: zhanghao
 * @date: 2021/10/24-11:53
 */

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Description
 */
public class JDBCUtil {

    public static Connection getConnection() throws Exception {

        //1.读取配置文件
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        //2.加载配置文件
        Properties info = new Properties();
        info.load(is);

        //3.加载并注册驱动
        Class.forName(info.getProperty("driver"));

        //4.获取连接
        Connection connection = DriverManager.getConnection(info.getProperty("url"), info.getProperty("user"), info.getProperty("password"));

        //5.返回连接
        return connection;
    }

    public static void closeResources(Connection conn, Statement s) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (s != null) {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResources2(Connection conn, Statement s,ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (s != null) {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
