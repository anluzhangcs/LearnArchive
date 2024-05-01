package org.zhang.dao;

/**
 * @author: zhanghao
 * @date: 2021/11/30-12:37
 */

import org.zhang.bean.User;

import java.util.List;

/**
 * @Description
 */
public interface UserDao {
    void add(User user);

    void update(User user);

    void delete(Integer id);

    Integer queryCount();

    User queryUser(Integer id);

    List<User> queryAllUsers();

    void addBatchUser(List<User> users);

    void updateBatchUser(List<User> users);

    //

}
