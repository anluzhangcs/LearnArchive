package org.zhang.mybatis.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.zhang.mybatis.bean.Blog;
import org.zhang.mybatis.util.IdUtils;
import org.zhang.mybatis.util.MybatisUtils;

import java.util.*;

import static org.junit.Assert.*;


/**
 * @author: zhanghao
 * @date: 2022/2/22-15:42
 */
public class BlogMapperTest {

    @Test
    public void addBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", IdUtils.getUuid());
        map.put("title", "JavaSE");
        map.put("author", "Zhangsan");
        map.put("createTime", new Date());
        map.put("views", 9999);
        mapper.addBlog(map);

        map.put("id", IdUtils.getUuid());
        map.put("title", "JavaEE");
        map.put("author", "Zhangsan");
        map.put("createTime", new Date());
        map.put("views", 9999);
        mapper.addBlog(map);

        map.put("id", IdUtils.getUuid());
        map.put("title", "JavaWeb");
        map.put("author", "Zhangsan");
        map.put("createTime", new Date());
        map.put("views", 9999);
        mapper.addBlog(map);

        map.put("id", IdUtils.getUuid());
        map.put("title", "Mybatis");
        map.put("author", "Zhangsan");
        map.put("createTime", new Date());
        map.put("views", 9999);
        mapper.addBlog(map);

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void qureyIf() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,Object> map = new HashMap();
        map.put("title1", "JavaSE");
//        map.put("author", "Zhangsan");
        List<Blog> blogList = mapper.queryIf(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        sqlSession.close();

    }

    @Test
    public void queryChoose() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,Object> map = new HashMap();
        map.put("title", "JavaSE");
        map.put("author", "Zhangsan");
        List<Blog> blogList = mapper.queryChoose(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void queryForEach() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,Object> map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
//        ids.add(4);
        map.put("ids", Arrays.asList(1,2 ,4));

        List<Blog> blogList = mapper.queryForeach(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1,2,3);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}