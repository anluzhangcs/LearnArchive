package org.zhang.mybatis.dao;

/**
 * @author: zhanghao
 * @date: 2022/1/28-18:20
 */

import org.zhang.mybatis.bean.User;

import java.util.List;

/**
 * @Description
 */
public interface UserMapper {

    List<User> getAllUsers();

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(Integer id);

}
