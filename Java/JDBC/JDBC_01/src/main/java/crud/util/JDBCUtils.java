package crud.util;

/**
 * @author: zhanghao
 * @date: 2021/10/22-19:52
 */


import crud.bean.Customer;
import crud.bean.Order;
import exer.Student;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Description
 */
public class JDBCUtils {

    //获取数据库连接
    public static Connection getConnection() throws Exception{
        //读取配置文件
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties info = new Properties();
        info.load(is);

        Class.forName(info.getProperty("driver"));

        Connection connection = DriverManager.getConnection(info.getProperty("url"), info.getProperty("user"), info.getProperty("password"));

        return connection;

    }

    //关闭数据库资源,适用于增删改
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

    //关闭数据库资源,适用于查
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

    //通用增删改操作
    public static void update(String sql, Object... args) throws Exception {

        //1.获取连接
        Connection conn = getConnection();

        //2.获取PreparedStatement对象
        PreparedStatement ps = conn.prepareStatement(sql);

        //3.填充占位符
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }

        //5.执行
        ps.execute();

        //6.关闭资源
        closeResources(conn,ps);
    }

    //针对Customers表的通用查询操作,只返回一个结果
    public static Customer queryForCustomer(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1.获取数据库连接
            conn = getConnection();

            //2.获取PreparedStatement对象
            ps = conn.prepareStatement(sql);

            //3.填充sql语句
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            //4.获取结果集和结果集元数据
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount(); //获取结果集列数

            if (rs.next()) { //判断结果集中是否有数据
                Customer customer = new Customer();
                for (int i = 1; i <= columnCount; i++) {
                    Object columnValue = rs.getObject(i); //获取列值

                    //注:这里获取的列明为数据库表的列名,通过列名获取Bean的属性,因此要保证
                    //列名和属性名要相同,否则会出错
                    String columnName = rsmd.getColumnName(i);
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true); //确保filed可访问
                    field.set(customer, columnValue);
                }
                return customer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources2(conn, ps, rs);
        }

        return null;
    }

    //针对Student表查询的通用操作
    public static Student queryForStudent(String sql, Object... args) throws Exception {

        //1.获取连接
        Connection conn = getConnection();

        PreparedStatement ps = conn.prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }

        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        if (rs.next()) {
            Student student = new Student();

            for (int i = 1; i <= columnCount; i++) {

                Object columnValue = rs.getObject(i);
                //总结:Bean的属性名和表的字段名或者字段别名中一个必须一致
                String columnLabel = rsmd.getColumnLabel(i); //获取列名别名

                Field field = Student.class.getDeclaredField(columnLabel);
                field.setAccessible(true);
                field.set(student, columnValue);
            }
            return student;
        }

        JDBCUtils.closeResources2(conn, ps, rs);

        return null;
    }


    //针对Order表查询的通用操作
    public static Order queryForOrder(String sql, Object... args) throws Exception {

        //1.获取连接
        Connection conn = getConnection();

        PreparedStatement ps = conn.prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }

        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        if (rs.next()) {
            Order order = new Order();

            for (int i = 1; i <= columnCount; i++) {

                Object columnValue = rs.getObject(i);
                //总结:Bean的属性名和表的字段名或者字段别名中一个必须一致
                String columnLabel = rsmd.getColumnLabel(i); //获取列名别名

                Field field = Order.class.getDeclaredField(columnLabel);
                field.setAccessible(true);
                field.set(order, columnValue);
            }
            return order;
        }

        JDBCUtils.closeResources2(conn, ps, rs);

        return null;
    }

    //针对于任意表的通用查询操作,查询多条记录
    public static <T> List<T> query(Class<T> clazz,String sql, Object... args) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);


            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }    

            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            list = new ArrayList<>();
            while (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    Object columnValue = rs.getObject(i);
                    String columnLabel = rsmd.getColumnLabel(i);

                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources2(conn, ps, rs);
        }
        return list;
    }


    public static <T> T selectOne(Class<T> clazz, String sql, Object... args) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.获取数据库连接
            conn = JDBCUtils.getConnection();

            // 2.预编译sql语句，得到PreparedStatement对象
            ps = conn.prepareStatement(sql);

            // 3.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            // 4.执行executeQuery(),得到结果集：ResultSet
            rs = ps.executeQuery();

            // 5.得到结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();

            // 6.1通过ResultSetMetaData得到columnCount,columnLabel；通过ResultSet得到列值
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {// 遍历每一个列

                    // 获取列值
                    Object columnVal = rs.getObject(i + 1);
                    // 获取列的别名:列的别名，使用类的属性名充当
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    // 6.2使用反射，给对象的相应属性赋值
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnVal);

                }

                return t;

            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            // 7.关闭资源
            JDBCUtils.closeResources2(conn, ps, rs);
        }

        return null;

    }
}
