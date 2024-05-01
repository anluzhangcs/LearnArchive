package Dao;

/**
 * @author: zhanghao
 * @date: 2021/10/24-17:07
 */

import bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description 针对Customer表的一些具体操作
 */
public interface CustomerDao {

    //添加一条客户记录
    void addCustomer(Connection conn, Customer cust) throws SQLException;

    //删除一条客户记录
    void deleteById(Connection conn, int id) throws SQLException;

    //修改一条用户记录
    void updateCustomer(Connection conn, Customer customer) throws SQLException;

    //查找用户根据姓名
    List<Customer> queryByName(Connection conn, String name) throws SQLException;

    //查找特殊数据,如最值,总数...etc
    //查找记录数
    long countAll(Connection conn) throws SQLException;

    //查找年龄最大值,即birth最小的
    Date queryMaxAge(Connection conn) throws SQLException;
}
