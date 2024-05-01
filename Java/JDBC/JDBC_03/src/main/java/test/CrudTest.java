package test;

/**
 * @author: zhanghao
 * @date: 2021/10/25-11:14
 */

import Dao.CustomerImp;
import bean.Customer;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @Description
 */
public class CrudTest {
    @Test
    public void test1() {

        Connection conn = null;
        try {
            //获取连接
            conn = JDBCUtil.getConnection();

            CustomerImp customerImp = new CustomerImp();

            //创建工具类对象runner
            QueryRunner runner = new QueryRunner();
            customerImp.setRunner(runner);

            //添加操作
            customerImp.addCustomer(conn, new Customer("王朝", "asc@pp.com", new Date(23895723535L)));

            //修改操作
            customerImp.updateCustomer(conn,new Customer(23,"赵虎", "asc@pp.com", new Date(33895723535L)));

            //删除操作
            customerImp.deleteById(conn,24);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //使用DbUtils关闭资源,和我们自己写的差不多
            //注意:这里的关闭连接实际上是将连接放回连接池,而我们自己写的是真正关闭连接
            DbUtils.closeQuietly(conn);
        }

    }

    @Test
    //查询测试
    public void test2() {
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();

            CustomerImp customerImp = new CustomerImp();
            QueryRunner runner = new QueryRunner();
            customerImp.setRunner(runner);

            List<Customer> customers = customerImp.queryByName(conn, "周杰伦");
            customers.forEach(System.out::println);

            Date date = customerImp.queryMaxAge(conn);
            System.out.println(date);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }

    }
}
