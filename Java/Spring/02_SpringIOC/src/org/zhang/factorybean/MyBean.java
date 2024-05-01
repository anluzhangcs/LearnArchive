package org.zhang.factorybean;

/**
 * @author: zhanghao
 * @date: 2021/11/22-21:52
 */

import org.springframework.beans.factory.FactoryBean;
import org.zhang.bean.Course;

/**
 * @Description 测试工厂Bean(FactoryBean)的对象
 */
public class MyBean implements FactoryBean<Course> {

    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("OS");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
