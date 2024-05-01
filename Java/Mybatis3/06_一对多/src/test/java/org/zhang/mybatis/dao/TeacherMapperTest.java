package org.zhang.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.zhang.mybatis.bean.Teacher;
import org.zhang.mybatis.util.MybatisUtils;

import static org.junit.Assert.*;


/**
 * @author: zhanghao
 * @date: 2022/2/22-11:36
 */
public class TeacherMapperTest {

    @Test
    public void getTeacherInfo1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherInfo1(1);
        System.out.println(teacher);

        sqlSession.close();
    }

    @Test
    public void getTeacherInfo2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherInfo2(1);
        System.out.println(teacher);

        sqlSession.close();
    }
}