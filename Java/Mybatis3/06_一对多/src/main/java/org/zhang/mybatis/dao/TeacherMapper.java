package org.zhang.mybatis.dao;

/**
 * @author: zhanghao
 * @date: 2022/2/22-11:12
 */

import org.apache.ibatis.annotations.Param;
import org.zhang.mybatis.bean.Teacher;

/**
 * @Description 一对多 获取指定老师的信息,包括该老师的所有学生
 */
public interface TeacherMapper {


    public Teacher getTeacherInfo1(@Param("tno") int tno);

    public Teacher getTeacherInfo2(@Param("tno") int tno);


}
