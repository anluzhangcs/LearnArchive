package Dao;

/**
 * @author: zhanghao
 * @date: 2021/10/25-10:36
 */

import bean.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description 使用DBUtils包下的工具类来执行crud操作(QueryRunner)和资源关闭操作(DBUtils)
 */
public class CustomerImp implements CustomerDao {

    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void addCustomer(Connection conn, Customer cust) throws SQLException {
        String sql = "insert into customers(name,email,birth) values(?,?,?)";
        String name = cust.getName();
        String email = cust.getEmail();
        Date birth = cust.getBirth();
        //调用QueryRunner中提供的curd方法
        runner.update(conn, sql, name, email, birth);

    }

    public void deleteById(Connection conn, int id) throws SQLException {
        String sql = "delete from customers where id = ?";
        runner.update(conn, sql, id);
    }

    public void updateCustomer(Connection conn, Customer customer) throws SQLException {
        String sql = "update customers set name=?,email=?,birth=? where id = ?";
        int id = customer.getId();
        String name = customer.getName();
        String email = customer.getEmail();
        Date birth = customer.getBirth();
        runner.update(conn, sql, name, email,birth, id);
    }

    public List<Customer> queryByName(Connection conn, String name) throws SQLException {
        String sql = "select id,name,email,birth from customers where name=?";
        List<Customer> customers = runner.query(conn, sql, new BeanListHandler<Customer>(Customer.class), name);
        return customers;
    }

    //获取单例数据,如最值,count等,ResultSetHandler使用ScalarHandler
    public long countAll(Connection conn) throws SQLException {
        String sql = "select count(*) from customers";
        int count = runner.query(conn, sql, new ScalarHandler<>(1));
        return count;
    }

    public Date queryMaxAge(Connection conn) throws SQLException {
        String sql = "select max(birth) from customers";
        Date btirh = runner.query(conn, sql, new ScalarHandler<>(1));
        return btirh;
    }
}
