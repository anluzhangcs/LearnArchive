package org.zhang.lifetime;

/**
 * @author: zhanghao
 * @date: 2021/11/23-20:08
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Description 后置处理器的类
 */
public class MyPostBean  implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第三步,在bean的init方法之前执行-postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第五步,在bean的init方法之后执行-postProcessAfterInitialization");
        return null;
    }
}
