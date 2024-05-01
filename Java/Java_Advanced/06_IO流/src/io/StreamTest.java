package io;

/**
 * @author: zhanghao
 * @date: 2021/10/11-18:58
 */

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description FileInputStream FileOutputStream 字节流的使用
 */
public class StreamTest {

    @Test
    /*
     * @Description  使用字节流进行文本文件的读取操作
     *  注:若使用字节流进行读取文本文件数据,且其中还有中文,易出现乱码
     *  以abcde张豪==>abcde张��为例
     *  文本文件是utf-8编码,英文占一个字节,一个汉字占3个字节,盛装byte[]长度为5
     *  表示中文的三个字节被分开,易出现乱码.张之所以没有出现乱码,是因为刚好张的三个
     *  字节都在一个byte[],没有分开,而解码(变成String)又默认使用的utf-8
     */
    public void test1() {
        FileInputStream fis = null;
        try {
            File file = new File("hello1.txt");

            fis = new FileInputStream(file);

            //因为是字节流,所以用byte[]数组盛装
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {

                String str = new String(buffer, 0, len);
                System.out.print(str); //乱码:abcde张��
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭字节流
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    /*
     * @Description  使用字节流复制二进制文件,如视频
     *  注意点:字节流操作文本文件时,若只是单纯的复制,中间没有转换为字符串显示的话,
     *      是可以的,但一般不推荐
     */
    public void test2() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("D:\\All Download\\IDM\\美女.mp4");
            File desFile = new File("D:\\All Download\\meimei.mp4");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);

            byte[] buffer = new byte[1024]; //一般大小设置为1024,即1KB
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
