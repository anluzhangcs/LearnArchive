package org.zhang.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.zhang.mybatis.bean.Student;
import org.zhang.mybatis.util.MybatisUtils;

import static org.junit.Assert.*;


/**
 * @author: zhanghao
 * @date: 2022/2/22-11:24
 */
public class StudentMapperTest {

    @Test
    public void getStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        for (Student student : mapper.getStudent()) {
            System.out.println(student);
        }

        sqlSession.close();
    }
}