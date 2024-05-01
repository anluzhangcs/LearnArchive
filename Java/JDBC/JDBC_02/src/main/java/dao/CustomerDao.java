package dao;

/**
 * @author: zhanghao
 * @date: 2021/10/24-17:07
 */

import bean.Customer;

import java.sql.Connection;
import java.util.List;

/**
 * @Description 针对Customer表的一些具体操作
 */
public interface CustomerDao {

    //添加一条客户记录
    void addCustomer(Connection conn,Customer cust);

    //删除一条客户记录
    void deleteById(Connection conn,int id);

    //修改一条用户记录
    void updateCustomer(Connection conn,Customer customer);

    //查找用户根据姓名
    List<?> queryByName(Connection conn,String name);
}
