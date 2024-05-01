package dao;

/**
 * @author: zhanghao
 * @date: 2021/10/24-16:44
 */

import utils.JDBCUtil;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 基本Dao,封装了对数据库的通用操作
 */
public abstract class BaseDao<T> {

    private Class<T> clazz;
    //获取子类对象继承父类指定泛型的类型,这样查询时就不用传递返回值类型的Class实例了
    {
        //1.获取当前this所指对象的带泛型的父类类型,Type是所有类的父接口
        Type superclass = this.getClass().getGenericSuperclass();

        //2.强转为ParameterizedType,即为带泛型的类型,便于调用下面的方法
        ParameterizedType type = (ParameterizedType) superclass;

        //3.获取父类的实际泛型类型数组
        Type[] types = type.getActualTypeArguments(); //获取实际的泛型类型参数数组

        //4.将第一个泛型类型强转为Class
        clazz = (Class<T>) types[0];
    }

    //引入事务之后的通用查询操作-一条记录
    public T queryOne(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取ps
            ps = conn.prepareStatement(sql);

            //填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            //执行查询并获取结果集
            rs = ps.executeQuery();
            //获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取结果集列数
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                //创建对象
                T t = (T) clazz.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    String columnLabel = rsmd.getColumnLabel(i); //获取列的别名
                    Object columnValue = rs.getObject(columnLabel); //获取列的值

                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResources2(null,ps,rs);
        }
        return null;
    }


    //引入事务之后的通用查询操作-多条记录
    public List<T> queryMore(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取ps
            ps = conn.prepareStatement(sql);

            //填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            //执行查询并获取结果集
            rs = ps.executeQuery();
            //获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取结果集列数
            int columnCount = rsmd.getColumnCount();

            //创建ArrayList
            List<T> list = new ArrayList();

            while (rs.next()) {
                //创建对象
                T t = (T) clazz.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    String columnLabel = rsmd.getColumnLabel(i); //获取列的别名
                    Object columnValue = rs.getObject(columnLabel); //获取列的值

                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResources2(null,ps,rs);
        }
        return null;
    }



    //引入事务之后的通用update操作
    public void update(Connection conn, String sql, Object ...args) {

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtil.closeResources(null, ps);
        }
    }
}
