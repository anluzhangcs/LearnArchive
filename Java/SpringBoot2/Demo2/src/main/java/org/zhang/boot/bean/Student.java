package org.zhang.boot.bean;

/**
 * @author: zhanghao
 * @date: 2022/4/15-17:04
 */


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description
 */


@Component
@ConfigurationProperties(prefix = "student")
@Data
@NoArgsConstructor
@ToString

public class Student {

    private String name;
    private int age;
    private String sex;
    private Date birth;

    private String[] hobby;
    private List<String> friends;
    private Map<String, List<Integer>> info;
    private School school;

}
