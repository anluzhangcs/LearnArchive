package utils;

/**
 * @author: zhanghao
 * @date: 2021/10/24-22:30
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Description
 */
public class JDBCUtil {

    public static Connection getConnection1() throws SQLException {
        /*
         * @Description  创建数据库连接池并手动对其进行配置(不推荐)
         *  基本配置:Driver,url,user,password
         *      -可以不配置Driver,druid连接池会根据url来自动识别并配置相应驱动
         *      -url中localhost:3306可以省略
         *      -数据库连接池的创建要放在外面,保证只有一个数据库连接池
         */
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriver(new com.mysql.cj.jdbc.Driver());
        dataSource.setUrl("jdbc:mysql:///test?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

//        DruidDataSourceFactory.createDataSource();
        Connection conn = dataSource.getConnection();
        return conn;
    }

    private static DataSource dataSource;
    static {
        Properties info = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        try {
            info.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataSource = DruidDataSourceFactory.createDataSource(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws Exception {


        /*
         * @Description  使用DruidDataSourceFactory加载.properties文件来创建数据库连接池(推荐)
         *  -DruidDataSourceFactory自动读取配置文件,因此key值必须和连接池规定的key值一致
         *  -同理,配置文件中driverClassName可以省略
         *  -url中localhost:3306可以省略
         *  -数据库连接池的创建要放在外面,保证只有一个数据库连接池
         */
        return dataSource.getConnection();

    }

    public static void closeResources(Connection conn,Statement s){
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
    public static void closeResources(Connection conn, Statement s, ResultSet rs){
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
