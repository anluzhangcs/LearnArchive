package org.zhang.mybatis.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.zhang.mybatis.bean.User;
import org.zhang.mybatis.util.MybatisUtils;

import java.util.List;

import static org.junit.Assert.*;


/**
 * @author: zhanghao
 * @date: 2022/2/21-12:36
 */
public class UserMapperTest {

    @Test
    public void getAllUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getAllUser();
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(2);
        System.out.println(user);

        sqlSession.close();
    }


    @Test
    public void getUserByTwo() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserByTwo(2, "张龙");
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void saveUser() {

    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(2, "张丹", "54678"));

        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(6);

        sqlSession.close();

    }
}