package org.zhang.test;

/**
 * @author: zhanghao
 * @date: 2022/1/21-17:59
 */

import org.junit.Test;
import sun.security.util.Length;

import java.util.Arrays;

/**
 * @Description
 */
public class TestA {

    @Test
    public void test1() {
        String str = "233.34.234.asf.jpg";
        String[] split = str.split("\\.");
        System.out.println(Arrays.toString(split));

        System.out.println(split[split.length - 1]);
    }

}
