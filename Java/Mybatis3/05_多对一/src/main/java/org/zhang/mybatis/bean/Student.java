package org.zhang.mybatis.bean;

/**
 * @author: zhanghao
 * @date: 2022/2/21-20:49
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int sno;

    private String sname;

    private Teacher teacher;
}
