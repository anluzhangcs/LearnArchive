package crud.preparedstatement;

/**
 * @author: zhanghao
 * @date: 2021/10/22-21:04
 */

import crud.bean.Customer;
import crud.bean.Order;
import crud.util.JDBCUtils;
import org.junit.Test;

import java.sql.*;
import java.util.List;

/**
 * @Description 查询操作
 */
public class QueryTest {


    @Test
    public void testQuery4() {
        String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id < ? " ;
        List<Order> orders = JDBCUtils.query(Order.class, sql, 5);
        orders.forEach(System.out::println);
        System.out.println("***************");
        String sql1 = "select name,id,email,birth from customers";
        List<Customer> customer = JDBCUtils.query(Customer.class, sql1);
        customer.forEach(System.out::println);

    }

    @Test
    public void testQuery3() {
        //如果查询语句中有表名或字段名是关键字,应用``包起来,如`order`
        String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ? " ;
        try {
            Order order = JDBCUtils.queryForOrder(sql, 1);
            System.out.println(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testQuery2() {
        String sql = "select name,id,email,birth from customers where name = ?";
        Customer customer = JDBCUtils.queryForCustomer(sql, "周杰伦");
        System.out.println(customer);
    }

    @Test
    public void testQuery1() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            //1.获取数据库连接
            conn = JDBCUtils.getConnection();

            //2.预编译sql语句并生成PreparedStatement对象
            String sql = "select id,name,email,birth from customers where id = ?";
            ps = conn.prepareStatement(sql);

            //3.填充占位符
            ps.setObject(1, 1);

            //4.执行查询语句
            resultSet = ps.executeQuery();

            //5.取出结果集中数据并封装为对象
            //注:next()方法会判断结果集下一条记录是否为null,如果非空,指针下移,返回true;否则返回false
            if (resultSet.next()) {
                int id = (Integer) resultSet.getObject(1);
                String name = (String) resultSet.getObject(2);
                String email = (String) resultSet.getObject(3);
                Date birth = (Date) resultSet.getObject(4);
                Customer customer = new Customer(id,name,email,birth);
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            JDBCUtils.closeResources2(conn,ps,resultSet);
        }

    }
}
