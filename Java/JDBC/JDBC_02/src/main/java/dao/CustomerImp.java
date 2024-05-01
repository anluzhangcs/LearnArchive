package dao;

/**
 * @author: zhanghao
 * @date: 2021/10/24-17:08
 */

import bean.Customer;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @Description
 */
public class CustomerImp extends BaseDao<Customer> implements CustomerDao {
    @Override
    public void addCustomer(Connection conn, Customer cust) {
        String sql = "insert into customers(name,email,birth) values(?,?,?)";
        String name = cust.getName();
        String email = cust.getEmail();
        Date birth = cust.getBirth();
        update(conn,sql,name,email,birth);
    }

    @Override
    public void deleteById(Connection conn,int id) {
        String sql = "delete from customers where id = ?";
        update(conn,sql,id);
    }

    @Override
    public void updateCustomer(Connection conn,Customer cust) {
        String sql = "update customers set name=?,email=?,birth=? where id = ?";
        int id = cust.getId();
        String name = cust.getName();
        String email = cust.getEmail();
        Date birth = cust.getBirth();
        update(conn,sql,name,email,birth,id);
    }

    @Override
    public List<Customer> queryByName(Connection conn,String name) {
        String sql = "select id,name,email,birth from customers where name=?";
        List<Customer> customers = queryMore(conn, sql, name);
        return customers;
    }
}
