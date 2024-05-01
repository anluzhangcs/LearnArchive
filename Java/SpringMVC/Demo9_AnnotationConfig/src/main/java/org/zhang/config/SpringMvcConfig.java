package org.zhang.config;

/**
 * @author: zhanghao
 * @date: 2022/1/23-13:51
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.zhang.interceptors.TestInterceptor;

import java.util.List;
import java.util.Properties;

/**
 * @Description SpringMVC配置类
 * 常见配置如下:
 *      开启组件扫描
 *      视图解析器
 *      MVC注解驱动
 *      MVC视图控制器(view-controller)
 *      开启静态资源访问(default-servlet-handler)
 *      拦截器
 *      异常处理器
 *
 */

@Configuration //标识这是一个配置类
@ComponentScan(value = {"org.zhang"}) //开启组件扫描
@EnableWebMvc //开启MVC注解驱动
public class SpringMvcConfig implements WebMvcConfigurer {
    //继承WebMvcConfigurer接口,其中提供了一些SpringMVC常用配置的一些方法

    //设置视图控制器
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    //设置静态资源访问
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable(); //开启SpringMVC默认的Servlet控制器
    }

    //设置拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns添加拦截路径,excludePathPatterns排除拦截路径
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**").excludePathPatterns("/");

    }

    //设置异常处理器
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        Properties prop = new Properties();
        prop.setProperty("java.lang.ArithmeticException", "error");
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        simpleMappingExceptionResolver.setExceptionMappings(prop);
        simpleMappingExceptionResolver.setExceptionAttribute("ex");
        resolvers.add(simpleMappingExceptionResolver);
    }

    //设置文件上传解析器

    //配置生成模板解析器
    @Bean
    public ITemplateResolver templateResolver() {
        WebApplicationContext webApplicationContext =
                ContextLoader.getCurrentWebApplicationContext();
// ServletContextTemplateResolver需要一个ServletContext作为构造参数，可通过WebApplicationContext 的方法获得
        ServletContextTemplateResolver templateResolver = new
                ServletContextTemplateResolver(
                webApplicationContext.getServletContext());
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }
    //生成模板引擎并为模板引擎注入模板解析器
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver
                                                       templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }
    //生成视图解析器并未解析器注入模板引擎
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }

}
