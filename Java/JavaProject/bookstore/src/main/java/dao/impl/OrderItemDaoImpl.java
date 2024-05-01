package dao.impl;

/**
 * @author: zhanghao
 * @date: 2021/11/9-13:55
 */

import bean.OrderItem;
import dao.OrderItemDao;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description
 */
public class OrderItemDaoImpl implements OrderItemDao {

    private QueryRunner runner = new QueryRunner();

    @Override
    public void save(OrderItem orderItem) {

        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
            runner.update(conn, sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
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
