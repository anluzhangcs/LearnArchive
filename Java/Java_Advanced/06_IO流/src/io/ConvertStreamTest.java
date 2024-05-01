package io;

/**
 * @author: zhanghao
 * @date: 2021/10/12-9:35
 */

import org.junit.Test;

import java.io.*;

/**
 * @Description 转换流的使用(转换流也是处理流的一种)
 *  InputStreamReader(输入流,字符流) 将字节流转换为字符流,解码过程
 *  OutputStreamWriter(输出流,字符流) 将字符流转换为字节流,编码过程
 *
 */
public class ConvertStreamTest {

    @Test
    /*
     * @Description  实现将utf-8的文本文件复制为gbk编码
     *  -字符集改变,文本文件的大小也会发生改变
     */
    public void test1() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            //省略了File对象的创建,实际上FileReader构造器中还是会创建File对象
            FileInputStream fr = new FileInputStream("hello1.txt");
            FileOutputStream fw = new FileOutputStream("hello.txt");

            //在转换流的构造器中都是字节流,且可以指定字符集
            //InputStreamReader和InputStream对应
            //OutputStreamWriter和OutputStream对应
            isr = new InputStreamReader(fr);
            osw = new OutputStreamWriter(fw,"gbk");

            char[] cbuf = new char[10];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                osw.write(cbuf);
//                String str = new String(cbuf, 0, len);
//                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {

                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {

                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
