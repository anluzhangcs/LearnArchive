package io;

/**
 * @author: zhanghao
 * @date: 2021/10/11-20:06
 */

import org.junit.Test;

import java.io.*;

/**
 * @Description 缓冲流
 *  特点:包在节点流的外层
 *  作用:提高流的读取,写入速度
 *  原理:缓冲流中有一个缓冲区,bis读取数据直到缓冲区满,然后flush清空缓存区写入
 *  BufferedInputStream类中静态变量DEFAULT_BUFFER_SIZE为缓冲区的最大值
 *
 *  BufferedInputStream BufferedOutputStream字节缓冲流
 *  BufferedReader BufferedWriter   字符缓冲流
 *
 */
public class BufferTest {

    @Test
    public void test1() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("wangfei.jpg");
            File desFile = new File("meimei.jpg");

            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(desFile);

            //使用节点流创建缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //使用缓冲流进行复制操作

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                //write()里自动进行flush操作,将整个缓冲区一次写入并清空
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            //注:先关外层,后关内层;外层关闭,内层自动关闭
            if (bis != null) {

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {

                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test2() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("art.txt")));

            //读取数据:
            //方法1 read(char[])
//            char[] cbuf = new char[10];
//            int len;
//            while ((len = br.read(cbuf)) != -1) {
//                bw.write(cbuf, 0, len);
//            }
            //方法2 readLine() 一行一行的读取,不包括换行
            String str;
            while ((str = br.readLine()) != null) {
                bw.write(str);
                bw.newLine();//手动换行操作
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关流
            if (br != null) {

                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {

                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
