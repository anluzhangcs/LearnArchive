package test;

import org.junit.Test;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * @author: zhanghao
 * @date: 2021/10/30-22:09
 */
public class JdbcUtilsTest {

    @Test
    public void getConnection() {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
    }

}