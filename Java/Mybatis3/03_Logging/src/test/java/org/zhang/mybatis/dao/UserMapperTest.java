package org.zhang.mybatis.dao;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.zhang.mybatis.bean.User;
import org.zhang.mybatis.util.MybatisUtils;

import java.util.List;


/**
 * @author: zhanghao
 * @date: 2022/2/20-16:21
 */
public class UserMapperTest {

    @Test
    public void getAllUser() {

        //1.获取sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //2.通过sqlSession获取映射器文件(即映射器实现类)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //3.映射器实现类调用方法并执行相应sql
        List<User> userList = mapper.getAllUser();

        for (User user : userList) {
            System.out.println(user);
        }

    }

    @Test
    public void getUserById() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


    }

    @Test
    public void saveUser() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.saveUser(new User(6, "zh", "123456"));

        //增删改操作需要提交
        sqlSession.commit();

        sqlSession.close();

    }

    @Test
    public void updateUser() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(6, "zc", "123456"));

        //增删改操作需要提交
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void getUserLimit() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

//        分页方式1
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        Map<String, Integer> map = new HashMap<String, Integer>();
//        map.put("startIndex", 1);
//        map.put("pageSize", 2);
//        List<User> userList = mapper.getUserLimit(map);
//        for (User user : userList) {
//            System.out.println(user);
//        }

//        分页方式2
        RowBounds rowBounds = new RowBounds(0, 3);
        List<User> userList = sqlSession.selectList("org.zhang.zhang.dao.UserMapper.getUserLimit", null, rowBounds);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();

    }
}