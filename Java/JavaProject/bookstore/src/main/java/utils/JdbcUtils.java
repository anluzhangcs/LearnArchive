package utils;

/**
 * @author: zhanghao
 * @date: 2021/10/30-21:43
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Description JdbcUtils工具类
 */
public class JdbcUtils {

    private static DruidDataSource dataSource; //定义一个druid连接池成员变量

    static{
        //1.读取配置文件并放进Properties对象中
        InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties info = new Properties();
        try {
            info.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2.初始化连接池,通过DruidDataSourceFactory
        try {
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * @Description  获取数据库连接
     * @param
     * @return  java.sql.Connection
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /*
     * @Description  关闭连接,将其放进连接池,DbUtils已提供
     * @param conn
     * @return  void
     */



}
