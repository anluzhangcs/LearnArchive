package org.zhang.config;

/**
 * @author: zhanghao
 * @date: 2021/11/30-22:22
 */

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Description 纯注解开发
 */

//@Configuration
//@ComponentScan(basePackages = "org.zhang")
//@EnableTransactionManagement //开始事务注解
public class SpringConfig {

    //xml中的bean在配置类中可以用@Bean注解

    //数据库连接池
    @Bean
    public DruidDataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    //JdbcTemplate对象.注入dataSource时,Spring会在当前容器中找它的实现类对象,即直接注入容器中的数据库连接池
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    //DataSourceTransactionManager对象.同注入dataSource时,Spring会在当前容器中找它的实现类对象.
    @Bean
    public TransactionManager getTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
