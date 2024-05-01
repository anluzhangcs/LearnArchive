package org.zhang.mybatis.util;

/**
 * @author: zhanghao
 * @date: 2022/1/27-21:46
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description 获取SqlSessionFactory实例并返回SqlSession的工具类
 */
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        //1.获取SqlSessionFactoryBuilder要读取的xml文件路径
        String resource = "mybatis-config.xml";

        //2.创建输入流并读取该xml配置文件
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3.获取SqlSession对象实例
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

}
