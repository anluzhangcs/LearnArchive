package org.zhang.springboot.bean;

/**
 * @author: zhanghao
 * @date: 2022/7/10-17:01
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @Description
 */

@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    String username;
    String password;
}
