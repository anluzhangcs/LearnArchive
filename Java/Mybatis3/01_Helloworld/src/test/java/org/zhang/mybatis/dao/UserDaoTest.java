package org.zhang.mybatis.dao;

/**
 * @author: zhanghao
 * @date: 2022/1/27-22:18
 */

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.zhang.mybatis.bean.User;
import org.zhang.mybatis.util.MybatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 测试
 */
public class UserDaoTest {

    @Test
    public void test1() {
        SqlSession sqlSession = null;
        try {
            //1.获取sqlSession实例
            sqlSession = MybatisUtils.getSqlSession();

            System.out.println(sqlSession);

            //2.获取mapper(相当于获取UserMapper的实现类)
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            //3.执行方法绑定的相应SQL.
            List<User> userList = userMapper.getAllUsers();

            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4.关闭SqlSession
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }

    @Test
    public void getUserById() {
        //1.获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //2.获取映射器接口实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //3.执行SQL
        User user = userMapper.getUserById(3);
        System.out.println(user);

        //4.关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int res = userMapper.addUser(new User(7, "王朝", "123445"));
        System.out.println(res);

        //注意增删改操作需要提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.updateUser(new User(2, "张龙", "666666"));

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int i = userMapper.deleteUser(1);
        System.out.println(i);

        sqlSession.commit();

        sqlSession.close();

    }

    @Test
    public void getUserByIdAndName() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", 1);
        map.put("userName", "王朝");

        User user = userMapper.getUserByIdAndName(map);
        System.out.println(user);

        sqlSession.close();

    }

    @Test
    public void getUsersByLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.getUsersByLike("王");

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
