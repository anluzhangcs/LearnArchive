package org.zhang.mybatis.dao;

/**
 * @author: zhanghao
 * @date: 2022/2/20-15:52
 */

import org.zhang.mybatis.bean.User;

import java.util.List;
import java.util.Map;

/**
 * @Description 映射器接口
 */

public interface UserMapper {

    //查询所有
    List<User> getAllUser();

    //根据id查询
    User getUserById(Integer id);

    //增加用户
    Integer saveUser(User user);

    //更新用户
    Integer updateUser(User user);

    //删除用户
    Integer deleteUser(Integer id);

    //分页
    List<User> getUserLimit(Map<String, Integer> map);

}
