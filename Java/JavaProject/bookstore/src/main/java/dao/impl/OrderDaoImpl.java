package dao.impl;

/**
 * @author: zhanghao
 * @date: 2021/11/9-14:01
 */

import bean.Order;
import dao.OrderDao;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description
 */
public class OrderDaoImpl implements OrderDao {

    private QueryRunner runner = new QueryRunner();

    @Override
    public void save(Order order) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
            runner.update(conn, sql, order.getId(), order.getCreateTime(), order.getTotalprice(), order.getStatus(), order.getUserId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
