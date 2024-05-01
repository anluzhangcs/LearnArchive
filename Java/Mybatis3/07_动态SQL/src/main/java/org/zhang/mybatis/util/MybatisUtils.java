package org.zhang.mybatis.util;

/**
 * @author: zhanghao
 * @date: 2022/2/22-14:39
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

    private static SqlSessionFactory factory;

    public MybatisUtils() {
    }

    public static SqlSession getSqlSession() {
        return factory.openSession();
    }

    static {
        InputStream is = null;

        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException var2) {
            var2.printStackTrace();
        }

        factory = (new SqlSessionFactoryBuilder()).build(is);
    }

}
