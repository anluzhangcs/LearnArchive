package org.zhang.mybatis.util;

/**
 * @author: zhanghao
 * @date: 2022/2/22-11:11
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

    static {
        InputStream is = null;

        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        factory = new SqlSessionFactoryBuilder().build(is);
    }

    public static SqlSession getSqlSession() {
        return factory.openSession();
    }


}
