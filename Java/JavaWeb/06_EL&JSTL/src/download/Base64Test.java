package download;

/**
 * @author: zhanghao
 * @date: 2021/11/2-19:09
 */

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @Description
 */
public class Base64Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //对中文进行Base64编码
        byte[] encode = Base64.getEncoder().encode("张三".getBytes());

        //解码
        byte[] decode = Base64.getDecoder().decode(encode);
        String s = null;

        s = new String(decode);

        System.out.println(s);
    }
}
