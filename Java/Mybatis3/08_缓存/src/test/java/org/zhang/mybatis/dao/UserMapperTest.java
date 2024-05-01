package org.zhang.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.zhang.mybatis.bean.User;
import org.zhang.mybatis.util.MybatisUtils;

import static org.junit.Assert.*;


/**
 * @author: zhanghao
 * @date: 2022/2/23-12:56
 */
public class UserMapperTest {

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();

        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.getUserById(1);
        System.out.println(user2);

        System.out.println(user == user2);

        sqlSession2.close();
    }
}