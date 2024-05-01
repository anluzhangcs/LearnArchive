package crud.preparedstatement;

/**
 * @author: zhanghao
 * @date: 2021/10/22-18:49
 */

import crud.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

/**
 * @Description PreparedStatement的crud操作
 *
 *  更新操作:create,update,delete ==>无返回值
 *  查询操作:result               ==>有返回值
 */
public class UpdateTest {

    @Test
    public void testDelete() {
        String sql = "delete from customers where id = ?";
        try {
            JDBCUtils.update(sql, 19);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    //更新数据库中的一条记录
    public void testUpdate() {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库连接
            connection = JDBCUtils.getConnection();

            //2.预编译sql语句并返回PreparedStatement实例
            String sql = "update customers set name = ? where id = ?";
            ps = connection.prepareStatement(sql);

            //3.填充占位符
            ps.setObject(1,"莫扎特");
            ps.setObject(2, 18);

            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            JDBCUtils.closeResources(connection, ps);
        }

    }

    @Test
    public void testInsert() {
        InputStream is = null;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1.读取配置文件
            is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties info = new Properties();
            info.load(is);

            //2.加载并注册驱动
            String driver = info.getProperty("driver");
            Class.forName(driver);

            //3.获取url,user,password
            String url = info.getProperty("url");
            String user = info.getProperty("user");
            String password = info.getProperty("password");

            //4.通过DriverManager.getConnection()获取连接
            connection = DriverManager.getConnection(url, user, password);

            //5.获取PreparedStatement实现类对象
            //5.1 获取预编译sql语句,?为占位符
            String sql = "insert into customers(name,email,birth) values (?,?,?)";
            //5.2 通过sql语句创建PreparedStatement对象
            ps = connection.prepareStatement(sql);

            //6.设置要传入sql语句的值
            ps.setString(1, "张豪");
            ps.setString(2, "abc@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("2001-02-18");
            ps.setDate(3, new Date(date.getTime()));

            //7.执行sql语句
            ps.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            //8.关闭资源
            if (ps != null) {

                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {

                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
