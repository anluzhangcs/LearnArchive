package org.zhang.mybatis.dao;

/**
 * @author: zhanghao
 * @date: 2022/1/27-21:37
 */

import org.zhang.mybatis.bean.User;

import java.util.List;
import java.util.Map;

/**
 * @Description
 */
public interface UserMapper {

    //查询所有用户
    List<User> getAllUsers();

    //根据id查询指定用户
    User getUserById(Integer id);

    //添加用户
    int addUser(User user);

    //更新用户
    int updateUser(User user);

    //删除操作
    int deleteUser(Integer id);

    //Map传参注入SQL
    User getUserByIdAndName(Map<String, Object> map);

    //模糊查询
    List<User> getUsersByLike(String name);


}
