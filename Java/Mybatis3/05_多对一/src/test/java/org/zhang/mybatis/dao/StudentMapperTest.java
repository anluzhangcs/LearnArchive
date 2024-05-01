package org.zhang.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.zhang.mybatis.bean.Student;
import org.zhang.mybatis.util.MybatisUtils;

import java.util.List;

import static org.junit.Assert.*;


/**
 * @author: zhanghao
 * @date: 2022/2/21-21:54
 */
public class StudentMapperTest {

    @Test
    public void getStudent1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent1();
//        for (Student student : studentList) {
//            System.out.println(student);
//        }
//
//        sqlSession.close();
        System.out.println(studentList.get(1).getSname());
    }

    @Test
    public void getStudent2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent2();
        for (Student student : studentList) {
            System.out.println(student);
        }

        sqlSession.close();
    }
}