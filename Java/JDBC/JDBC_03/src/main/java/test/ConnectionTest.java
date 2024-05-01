package test;

/**
 * @author: zhanghao
 * @date: 2021/10/24-22:44
 */

import org.junit.Test;
import utils.JDBCUtil;

import java.sql.Connection;

/**
 * @Description
 */
public class ConnectionTest {
    @Test
    public void test1() {
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(conn);
    }
}
