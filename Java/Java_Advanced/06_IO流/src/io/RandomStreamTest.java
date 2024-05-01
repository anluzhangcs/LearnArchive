package io;

/**
 * @author: zhanghao
 * @date: 2021/10/13-17:09
 */

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Description java.io.RandomAccessFile 随机流
 *  -继承与java.lang.Object,与其他大多数继承基类的流不同
 *  -实现了DataInput和DataOutput接口
 *  -既可以做输入流,也可以做输出流
 *  -属于字节流
 *
 *  构造器: RandomAccessFile(String name ,String mode)
 *      -name为文件名
 *      -mode为模式:r代表只读,rw代表读写,rwd读写
 */
public class RandomStreamTest {

    @Test
    //实现图片的复制
    public void test1() {
        RandomAccessFile rafi = null;
        RandomAccessFile rafo = null;
        try {
            //输入流一般mode为r,输出流mode一般为rw
            rafi = new RandomAccessFile("wangfei.jpg","r");
            rafo = new RandomAccessFile("wangfei3.jpg", "rw");

            byte[] bytes = new byte[1024];
            int len;
            while ((len = rafi.read(bytes)) != -1) {
                rafo.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (rafi != null) {

                try {
                    rafi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (rafo != null) {

                try {
                    rafo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    /*
     * @Description  RandomAccessFile的读入问题
     *  其他输出流:若文件不存在,则创建该文件;若存在该文件,则创建流时将其清空
     *  RandomAccessFile:若文件不存在,则创建该文件;若存在,则从头开始覆盖
     *
     *  long getFilePointer() 返回RandomAccessFile流的指针位置
     *  void seek(long pos)   设置流开始的指针位置
     */
    public void test2() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("raf.txt", "rw");

            raf.write("vnvb".getBytes());
            System.out.println(raf.getFilePointer());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {

                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    /*
     * @Description  实现模拟插入操作
     *  -首先要seek(long pos)定位到要插入的位置
     *  -读取到后面的字符串保存
     *  -seek()回到原位置,并写入write
     *  -最后写入保存的字符串
     *
     *  方式1:使用StringBuilder或StringBuffer
     *  方式2:使用ByteArrayOutputStream
     */
    public void test3() {
        RandomAccessFile raf = null;
        ByteArrayOutputStream bos = null;
        try {
            raf = new RandomAccessFile("raf.txt", "rw");

            File file = new File("raf.txt");

            raf.seek(3); //设置指针位置

            //方式1 使用StringBuilder
            //创建文件字节数的StringBuilder,所以大小肯定够
//            StringBuilder builder = new StringBuilder((int) file.length());
//            byte[] bytes = new byte[20];
//            int len;
//            while ((len = raf.read(bytes)) != -1) {
//                builder.append(new String(bytes, 0, len));
//            }
//            raf.seek(3); //指针回到原来位置
//            raf.write("zxv".getBytes()); //进行插入
//            raf.write(builder.toString().getBytes()); //最后写入

            //2.使用
            //用file的字节数创建bos,也是够的
            bos = new ByteArrayOutputStream((int) file.length());
            byte[] bytes = new byte[20];
            int len;
            while ((len = raf.read(bytes)) != -1) {
                bos.write(bytes, 0, len); //写入bos底层的byte[]数组buf
            }
            raf.seek(3);
            raf.write("zhang".getBytes());
            //将bos转化为字节数组写入
            raf.write(bos.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {

                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bos != null) {

            }
        }


    }
}
