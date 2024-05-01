package org.zhang.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.zhang.mybatis.bean.Teacher;
import org.zhang.mybatis.util.MybatisUtils;

import static org.junit.Assert.*;


/**
 * @author: zhanghao
 * @date: 2022/2/21-21:02
 */
public class TeacherMapperTest {

    @Test
    public void getTeacher() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);

        sqlSession.close();
    }
}