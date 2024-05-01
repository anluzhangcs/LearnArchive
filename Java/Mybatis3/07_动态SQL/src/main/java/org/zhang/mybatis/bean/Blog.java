package org.zhang.mybatis.bean;

/**
 * @author: zhanghao
 * @date: 2022/2/22-14:31
 */

import lombok.Data;

import java.util.Date;

/**
 * @Description
 */

@Data
public class Blog {
    private String id;

    private String title;

    private String author;

    private Date createTime;

    private int views;
}
