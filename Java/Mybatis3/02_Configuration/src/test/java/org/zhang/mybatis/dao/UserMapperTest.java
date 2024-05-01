package org.zhang.mybatis.dao;

/**
 * @author: zhanghao
 * @date: 2022/1/28-18:25
 */

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.zhang.mybatis.bean.User;
import org.zhang.mybatis.util.MybatisUtils;

import java.util.List;

/**
 * @Description
 */
public class UserMapperTest {

    @Test
    public void getAllUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.getAllUsers();
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();

    }

}
