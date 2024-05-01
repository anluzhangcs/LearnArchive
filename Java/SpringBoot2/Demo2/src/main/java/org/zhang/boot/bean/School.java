package org.zhang.boot.bean;

/**
 * @author: zhanghao
 * @date: 2022/4/15-17:15
 */

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @Description
 */

@Component
@Data
@NoArgsConstructor
@ToString
public class School {

    private String name;
    private String position;
}
