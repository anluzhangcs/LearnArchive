package utils;

/**
 * @author: zhanghao
 * @date: 2021/11/3-14:55
 */

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Description 将Map对象一次性封装到Bean对象中
 *  使用BeanUtils.populate()方法,该方法的底层原理就是先获取Map中的key,然后调用bean对象
 *  的setXXX方法进行赋值.setXXX读方法的取名要和Map中key的值一样,否则数据保存不了.和EL表达式通过
 *  .运算通过写方法找到参数对应的值类似
 */
public class WebUtils {

    public static <T> T copyParamToBean(Map params, T bean) {

            try {
                BeanUtils.populate(bean,params);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        return bean;
    }

    public static Integer parseStr(String str, Integer defaultValue) {
        if (str == null) { //如果为null,直接返回默认值
            return defaultValue;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
