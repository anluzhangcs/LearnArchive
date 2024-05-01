package dao.impl;

/**
 * @author: zhanghao
 * @date: 2021/10/30-22:23
 */

import bean.User;
import dao.UserDao;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description
 */
public class UserDaoImpl implements UserDao {

    //QueryRunner是DbUtils提供的工具类
    private QueryRunner runner = new QueryRunner();


    @Override
    public User queryByName(String username) {
        Connection conn = null;
        User user = null;
        try {
            //获取连接
            conn = JdbcUtils.getConnection();

            //sql语句
            String sql = "select id,username,password,email from t_user where username=?";

            //执行查询语句,注意ResultSetHandler<T>的实现类
            user = runner.query(conn, sql, new BeanHandler<>(User.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;

    }

    @Override
    public User queryByEmail(String email) {

        Connection conn = null;
        User user = null;
        try {
            conn = JdbcUtils.getConnection();

            String sql = "select id,username,password,email from t_user where email=?";

            user = runner.query(conn, sql, new BeanHandler<>(User.class), email);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();

            String username = user.getUsername();
            String password = user.getPassword();
            String email = user.getEmail();

            String sql = "insert into t_user(username,password,email) values(?,?,?)";

            runner.update(conn, sql, username, password, email);
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

    @Override
    public User queryForLogin(String username, String password) {

        Connection conn = null;
        User user = null;
        try {
            conn = JdbcUtils.getConnection();

            String sql = "select id,username,password,email from t_user where username=? and password=?";

            user = runner.query(conn, sql, new BeanHandler<>(User.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
