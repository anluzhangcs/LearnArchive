package org.zhang.mybatis.util;

/**
 * @author: zhanghao
 * @date: 2022/1/28-18:21
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 */
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis-config.xml";

        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

}
