package transaction;

/**
 * @author: zhanghao
 * @date: 2021/10/24-18:44
 */

import bean.Customer;
import dao.CustomerImp;
import org.junit.Test;
import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Description 测试Dao层实现的对数据库的操作
 */
public class Test2 {

    @Test
    public void test1() {
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();

            CustomerImp customerImp = new CustomerImp();

            //1.添加用户
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            java.util.Date parse = sdf.parse("2001-02-18");
//            Date birth = new Date(parse.getTime());
//            customerImp.addCustomer
//                    (conn, new Customer("张豪", "123@gmail.com", birth));

            //2.删除用户
//            customerImp.deleteById(conn,22);

            //3.修改用户
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parse = sdf.parse("2021-10-2");
            Date birth = new Date(parse.getTime());
            customerImp.updateCustomer(conn, new Customer(23, "李四", "456@qq.com", birth));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResources(conn, null);
        }
    }

    @Test
    public void test2() {
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
            CustomerImp customerImp = new CustomerImp();

            //4.查找指定姓名客户
            List<?> list = customerImp.queryByName(conn, "李四");
            list.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeResources2(conn,null,null);
        }

    }
}
