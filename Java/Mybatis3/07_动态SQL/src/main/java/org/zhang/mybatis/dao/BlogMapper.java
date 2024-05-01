package org.zhang.mybatis.dao;

/**
 * @author: zhanghao
 * @date: 2022/2/22-14:38
 */

import org.apache.ibatis.annotations.Insert;
import org.zhang.mybatis.bean.Blog;

import java.util.List;
import java.util.Map;

/**
 * @Description
 */
public interface BlogMapper {

    //添加
    @Insert("insert into blog(id,title,author,create_time,views) values(#{id},#{title},#{author},#{createTime},#{views})")
    public int addBlog(Map map);

    //查询使用if
    public List<Blog> queryIf(Map map);

    //查询使用choose-when-otherwise
    public List<Blog> queryChoose(Map map);

    //更新
    public int updateBlog(Map map);

    //使用foreach查询
    public List<Blog> queryForeach(Map map);





}
