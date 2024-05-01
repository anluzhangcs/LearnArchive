package crud.preparedstatement;

/**
 * @author: zhanghao
 * @date: 2021/10/24-10:20
 */

import crud.util.JDBCUtils;
import org.junit.Test;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;

/**
 * @Description PreparedStatement代替Statement进行批量数据插入操作
 *
 *  update,delete,result本身就有批量处理的功能,而insert一条sql只能插入一条记录
 *  ==>如何批量插入,从而提升效率?
 */
public class InsertTest {

    @Test
    //通过jdbc执行ddl语句,创建Goods表,本质上就相当于update操作
    public void createGoods() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "create table Goods(id int primary key auto_increment , name varchar(25) );";
            ps = conn.prepareStatement(sql);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, ps);
        }



    }

    @Test
    //相较于Statement提升,PreparedStatement预编译sql语句,不用每一句都重新编译
    public void testInsert1() {
        long start = System.currentTimeMillis();

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "insert into Goods(name) values(?)";
            ps = conn.prepareStatement(sql);

            for (int i = 1; i <= 20000; i++) {

                ps.setString(1, "name" + i);
                ps.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn, ps);
        }

        long end = System.currentTimeMillis();
        System.out.println("花费的时间是(毫秒):" + (end -start )); //50576
    }

    @Test
    //使用addBatch,executeBatch,clearBatch对批量的sql语句统一执行
    //mysql默认没有开启批处理功能,需要在连接时开启rewriteBatchedStatements=true
    public void testInsert2() {
        long start = System.currentTimeMillis();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "insert into Goods(name) values(?)";
            ps = conn.prepareStatement(sql);

            for (int i = 1; i <= 20000; i++) {
                ps.setString(1, "name" + i);

                //积攒sql语句
                ps.addBatch();

                if (i % 500 == 0) {
                    //统一执行sql语句
                    ps.executeBatch();

                    //清空batch
                    ps.clearBatch();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn,ps);
        }

        long end = System.currentTimeMillis();
        System.out.println("花费的时间是(毫秒):" + (end -start ));

    }

    @Test
    //相较于test2,从连接着手,取消自动提交,先缓存起来,sql语句全部执行完后,统一提交
    public void testInsert3() {
        long start = System.currentTimeMillis();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);

            String sql = "insert into goods(name) values(?)";
            ps = conn.prepareStatement(sql);

            for (int i = 1; i <= 2000; i++) {
                ps.setString(1, "name" + i);
                ps.addBatch();

                if (i % 500 == 0) {
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResources(conn,ps);
        }

        long end = System.currentTimeMillis();
        System.out.println("花费的时间是(毫秒):" + (end -start ));
    }
}
