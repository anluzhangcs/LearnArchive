package org.zhang.mybatis.dao;

/**
 * @author: zhanghao
 * @date: 2022/2/22-11:10
 */

import org.apache.ibatis.annotations.Select;
import org.zhang.mybatis.bean.Student;

import java.util.List;

/**
 * @Description
 */
public interface StudentMapper {

    @Select("select * from student")
    public List<Student> getStudent();

}
