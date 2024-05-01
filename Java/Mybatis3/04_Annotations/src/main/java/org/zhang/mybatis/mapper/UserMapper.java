package org.zhang.mybatis.mapper;

/**
 * @author: zhanghao
 * @date: 2022/2/21-12:09
 */

import org.apache.ibatis.annotations.*;
import org.zhang.mybatis.bean.User;

import java.util.List;

/**
 * @Description Mybatis使用注解开发简单CRUD
 */
public interface UserMapper {

    //查找所有
    @Select("select * from user")
    public List<User> getAllUser();

    //根据id查找
    //当方法参数只有一个且为基本数据类型时,方法形参不需要@Param注解,也不用和sql语句占位符名一致
    @Select("select * from user where id = #{id2}")
    public User getUserById(Integer idd);

    //根据id和姓名查找
    //当有多个参数时,必须使用@Param注解,且@param注解属性值和占位符名必须一致
    @Select("select * from user where id = #{id} and username = #{username}")
    public User getUserByTwo(@Param("id") Integer id, @Param("username") String username);

    //增加用户
    @Insert("insert into user(id,username,password) values(#{id},#{username},#{pwd})")
    public Integer saveUser(User user);

    //修改用户
    @Update("update user set username = #{username},password = #{pwd} where id = #{id}")
    public Integer updateUser(User user);

    //删除用户
    @Delete("delete from user where id = #{id}")
    public Integer deleteUser(Integer id);

}
