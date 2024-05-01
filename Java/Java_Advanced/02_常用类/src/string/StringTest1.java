package string;

/**
 * @author: zhanghao
 * @date: 2021/9/26-19:36
 */

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @Description String类与其它数据类型的转换
 *
 *  String类转换为基本数据类型:
 *      1.xxx.parsexxx(String str) 将str转换为包装类
 *      2.包装类自动开箱就得到基本数据类型
 *
 *  基本数据类型,包装类转换为String:
 *      String.valueOf(基本数据类型);
 *
 */
public class StringTest1 {
    /*
     * String与byte[]数组间的转换
     * 注:byte[]字节数组,byte类型为基本数据类型,长度为一个字节,范围为-127-128,存放二进制编码
     *
     * String ==> byte[]    相当于编码过程,将能看懂的变成二进制存储字节
     *      调用String的byte[] getBytes()方法
     *      getBytes(String charsetName)还可以指定字符集进行编码
     *
     * byte[] ==> String    相当于解码过程,将字节转换为能看懂的
     *      调用String(byte[])构造器
     *      String(byte[],String charsetName)还可以指定字符集进行解码
     * 注:编码解码不一致会乱码
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String s1 = "abc123中国";
        byte[] bytes = s1.getBytes();//使用默认编码集
        byte[] gbk = s1.getBytes("gbk");

        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(gbk));

        String s2 = new String(bytes); //使用默认解码集
        System.out.println(s2);
        String s3 = new String(bytes, "gbk"); //编码解码不一致会乱码
        System.out.println(s3);
    }


    @Test
    public void test2() {
        String s1 = "helloworld";
        char[] arr = s1.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        char[] chs = {'1', '2', '3', '4', '5'};
        String s2 = new String(chs);
        System.out.println(s2);
    }

    @Test
    public void test1() {
        String s1 = "123";
        double num = 3.14;

        int i = Integer.parseInt(s1);
        System.out.println(i);

        System.out.println(String.valueOf(num));
    }
}
