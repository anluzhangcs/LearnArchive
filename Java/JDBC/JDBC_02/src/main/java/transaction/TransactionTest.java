package transaction;

/**
 * @author: zhanghao
 * @date: 2021/10/24-11:52
 */

import org.junit.Test;
import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Description 事务
 *  何为事务:事务就是一组逻辑操作单元,一般用于增删改等对数据库中数据进行修改的操作
 *  -事务具有原子性,要么执行成功commit;若中途出现错误,那么整个事务所作的操作都需要rollback,
 *  使数据回到最近一次commit之后的状态.
 *  -事务可以保持数据的一致性
 *
 *  -数据库操作一但commit,就不可以rollback
 *  -自动提交的操作:DDL,自动提交,不可改变
 *                 DML,一般的增删改查,默认自动提交,可以设置AutoCommit为false
 *                 关闭数据库连接
 *
 *   ==>要用到事务时,就要保证操作不会自动提交,当事务完成之后,统一提交,保持数据的一致性.
 *      要求:事务用一个数据库连接将一组逻辑操作单元串起来
 *          设置连接自动提交为false
 */
public class TransactionTest {

    @Test
    public void testTransaction() {
        Connection conn = null;

        try {
            //1.获取连接
            conn = JDBCUtil.getConnection();

            //2.设置自动提交为false
            conn.setAutoCommit(false);

            //3.事务过程,已转账为例
            //转钱
            String sql1 = "update user_table set balance=balance-100 where user = ?";
            update(conn, sql1, "AA");

            //模拟异常
//            System.out.println(10 / 0);

            //收钱
            String sql2 = "update user_table set balance = balance+100 where user = ?";
            update(conn, sql2, "BB");
            //4.提交
            conn.commit();
        } catch (Exception e) {
            //出现异常,回滚
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
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
