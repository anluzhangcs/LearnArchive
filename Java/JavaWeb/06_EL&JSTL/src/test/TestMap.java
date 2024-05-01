package test;

/**
 * @author: zhanghao
 * @date: 2021/11/1-19:46
 */

import java.util.HashMap;

/**
 * @Description
 */
public class TestMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("key", "value1");

        System.out.println(map.get("key"));
    }


}
