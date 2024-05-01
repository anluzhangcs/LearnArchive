package org.zhang.springboot.config;

/**
 * @author: zhanghao
 * @date: 2022/4/12-16:31
 */

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zhang.springboot.bean.Pet;
import org.zhang.springboot.bean.User;

/**
 * @Description @Configuration:声明这是一个配置类.配置类本身也是容器中的组件
 *  proxyBeanMethods:默认为true
 *      -true
 *      ①当直接调用方法获取bean时,始终返回这个单例对象
 *      ②表示Full模式,适用于组件之间有依赖关系,该模式下SpringBoot每次启动都会判断检查容器中是否存在该组件
 *
 *      -false.
 *      ①当直接调用方法获取bean时,每次返回一个新的对象
 *      ②表示Lite模式,适用于组件之间无依赖关系,跳过检查可以加快启动速度
 *
 */

@Configuration(proxyBeanMethods = true)
//@Import({User.class})
//@ConditionalOnBean(name = "tom")

//@EnableConfigurationProperties(Pet.class)
public class MyConfig {

    /*
     * @Description   @Bean注册组件,默认是单例的
     * 方法名为组件id,返回对象即为容器中的组件
     */
    @Bean
    public User user01() {
        User user = new User("zhangsan", 19);

        //组件之间产生依赖,当proxyBeanMethods为false时,每次注入的都是新的对象
        user.setPet(kitten());
        return user;
    }

    @Bean("kitten")
    public Pet kitten() {
        return new Pet();
    }
}
