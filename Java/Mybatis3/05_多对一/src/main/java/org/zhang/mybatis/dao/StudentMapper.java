package org.zhang.mybatis.dao;

/**
 * @author: zhanghao
 * @date: 2022/2/21-20:49
 */

import org.zhang.mybatis.bean.Student;

import java.util.List;

/**
 * @Description
 */
public interface StudentMapper {

    //查询所有学生信息,包括学生所对应的老师信息
    public List<Student> getStudent1();

    public List<Student> getStudent2();
}
