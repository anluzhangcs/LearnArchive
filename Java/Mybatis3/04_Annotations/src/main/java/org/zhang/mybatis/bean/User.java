package org.zhang.mybatis.bean;

/**
 * @author: zhanghao
 * @date: 2022/2/21-12:08
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
public class User {
    private Integer id;

    private String username;

    private String pwd;

}
