package io;

/**
 * @author: zhanghao
 * @date: 2021/10/12-13:11
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description 标准输入输出流的使用
 *  System.in和System.out
 */
public class SystemInTest {
    /*
     * @Description  从键盘输入字符串，要求将读取到的整行字符串转成大写输出。
     * 然后继续进行输入操作，直至当输入“e”或者“exit”时，退出程序。
     *
     * 注意点:
     *  1.idea不支持在Test单元测试中从键盘输入,要在main方法中
     *  2.要完成上述操作,需要用到BufferedReader的readLine()方法
     *  3.System.in和System.out都是字节流 ==>转换流==>BufferedReader
     */
    public static void main(String[] args) {

        //
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("请输入数据:");
                String str;
                str = br.readLine();
                if ("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)) {
                    System.out.println("正在退出...");
                    break;
                } else{
                    System.out.println(str.toUpperCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {

                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
