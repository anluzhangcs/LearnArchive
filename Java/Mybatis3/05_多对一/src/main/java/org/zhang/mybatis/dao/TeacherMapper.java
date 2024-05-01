package org.zhang.mybatis.dao;

/**
 * @author: zhanghao
 * @date: 2022/2/21-20:53
 */

import org.apache.ibatis.annotations.Select;
import org.zhang.mybatis.bean.Teacher;

/**
 * @Description
 */
public interface TeacherMapper {

    @Select("select * from teacher where tno = #{id}")
    public Teacher getTeacher(int id);

}
