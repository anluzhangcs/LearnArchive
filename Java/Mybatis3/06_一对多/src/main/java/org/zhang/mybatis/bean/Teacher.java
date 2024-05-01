package org.zhang.mybatis.bean;

/**
 * @author: zhanghao
 * @date: 2022/2/22-11:04
 */

import lombok.Data;

import java.util.List;

/**
 * @Description
 */

@Data
public class Teacher {

    private int tno;

    private String tname;

    private List<Student> students;

}
