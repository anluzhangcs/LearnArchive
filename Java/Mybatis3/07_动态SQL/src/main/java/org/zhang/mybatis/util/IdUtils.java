package org.zhang.mybatis.util;

/**
 * @author: zhanghao
 * @date: 2022/2/22-14:39
 */

import org.junit.Test;

import java.util.UUID;

/**
 * @Description 生成ID工具类
 */
public class IdUtils {

    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


}
