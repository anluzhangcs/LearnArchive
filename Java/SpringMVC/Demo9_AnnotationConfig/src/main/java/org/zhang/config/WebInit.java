package org.zhang.config;

/**
 * @author: zhanghao
 * @date: 2022/1/23-13:44
 */

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @Description web工程的初始化类,用于替代web.xml
 *  必须继承AbstractAnnotationConfigDispatcherServletInitializer
 */

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*
     * @Description  用于读取Spring配置文件
     *
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /*
     * @Description  用于读取SpringMVC配置文件
     *
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    /*
     * @Description  用于设置DispactherServlet的映射规则,即url-pattern
     *
     */
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    /*
     * @Description  注册过滤器
     */
    @Override
    protected Filter[] getServletFilters() {

        //设置编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("utf-8");
        characterEncodingFilter.setForceResponseEncoding(true);

        //设置请求过滤器
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();

        return new Filter[]{characterEncodingFilter,hiddenHttpMethodFilter};
    }
}
