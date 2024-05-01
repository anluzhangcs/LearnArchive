package org.zhang.mybatis.util;

/**
 * @author: zhanghao
 * @date: 2022/2/20-16:10
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description 读取mybatis配置文件并获取sqlsession
 */
public class MybatisUtils {

    //SqlSession的工厂 ==> 用于创建SqlSession
    private static SqlSessionFactory sqlSessionFactory;

    static {

        InputStream is = null;

        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

}
