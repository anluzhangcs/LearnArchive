package org.zhang.springboot.bean;

/**
 * @author: zhanghao
 * @date: 2022/4/12-16:40
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description
 */

//@ConfigurationProperties(prefix = "pet")
//@Component
public class Pet {
    private String type;
    private String name;


}
