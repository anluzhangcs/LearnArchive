package org.zhang.mybatis.dao;

/**
 * @author: zhanghao
 * @date: 2022/2/23-12:36
 */

import org.zhang.mybatis.bean.User;

/**
 * @Description
 */
public interface UserMapper {

    User getUserById(int id);

}
