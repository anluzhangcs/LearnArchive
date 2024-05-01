package org.zhang.dao;

/**
 * @author: zhanghao
 * @date: 2021/11/30-12:38
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.zhang.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description DAO层
 */

@Repository
public class UserDaoImpl implements UserDao {


    @Autowired //注入JdbcTemplate对象
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(User user) {
        String sql = "insert into t_user(username,password,email) values (?,?,?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public void update(User user) {
        String sql = "update t_user set username=?,password=?,email=? where id = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getId());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from t_user where id = ?";
        jdbcTemplate.update(sql,id);
    }


    @Override
    /*返回数量总和*/
    public Integer queryCount() {
        String sql = "select count(*) from t_user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public User queryUser(Integer id) {
        String sql = "select id id,username username,password password,email email from t_user where id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),id);
    }

    @Override
    public List<User> queryAllUsers() {
        String sql = "select id id,username username,password password,email email from t_user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return userList;
    }


    @Override
    public void addBatchUser(List<User> users) {

        String sql = "insert into t_user(username,password,email) values (?,?,?)";

        List<Object[]> batchArgs = new ArrayList<>();
        for (User user : users) {

            batchArgs.add(new Object[]{user.getUsername(),user.getPassword(),user.getEmail()});
        }
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }


    @Override
    public void updateBatchUser(List<User> users) {

        String sql = "update t_user set username=?,password=?,email=? where id = ?";

        List<Object[]> batchArgs = new ArrayList<>();
        for (User user : users) {

            batchArgs.add(new Object[]{user.getUsername(),user.getPassword(),user.getEmail(),user.getId()});
        }
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }


}
