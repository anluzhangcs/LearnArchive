package io;

/**
 * @author: zhanghao
 * @date: 2021/10/11-13:51
 */

import org.junit.Test;

import java.io.*;

/**
 * @Description IO流
 *  1.分类
 *  -流向：输入流(读取到内存) 输出流(输出到文件)
 *  -流的数据类型：字节流(一个个byte) 字符流(一个个char)
 *  -流是否直接对文件:节点流(文件流) 缓冲流(套在节点流上)
 *   抽象基类                 节点流                     缓冲流
 *  InputStream       FileInputStream            BufferedInputSream
 *  OutputStream      FileOutputStream           BufferedOutputStream
 *  Reader            FileReader                 BufferedReader
 *  Writer            FileWriter                 BufferedWriter
 */
public class IOTest {

    /*
     * @Description  FileReader的简单实用
     *  常用方法:
     *      read():获取文件字符,如果文件达到末尾,返回-1(类似于next())
     *
     *  注意:
     *      ①读取文件时文件一定要存在,否则创建流时会FileNotFoundException
     *      ②IO流使用之后一定要关闭,jvm不会自动回收,可能造成内存泄漏
     *      ③IO流的关闭一般使用try-catch-finally
     */
    @Test

    public void test1() {
        FileReader fr = null;
        try {
            //1.创建文件对象作为节点
            File file = new File("hello.txt"); //相对于module

            //2.创建FileReader文件输入流,字符流
            fr = new FileReader(file);

            //3.读取数据
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭fr
            try {
                if (fr != null) //防止fr为null造成NullPointerException
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2(){
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);

            //read()重载方法
            //1.定义一个长度为5的char数组用来盛装读取的字符流
            char[] data = new char[5];
            int len; //读取到字符流的长度
            while ((len = fr.read(data)) != -1) {
                //错误写法
//                for (int i = 0; i < data.length; i++) {
//                    System.out.print(data[i]);//abcde张豪cde
//                }
                //正确写法
                for (int i = 0; i < len; i++) {
                    System.out.print(data[i]);//abcde张豪
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /*
     * @Description  FileWriter的使用
     *  常用方法:
     *      write(String str)
     *      write(int c)  写入c ASCLL码对应的字符
     *      write(String str,int offset,int length)
     *      write(char[] arr)
     *
     *  注意:
     *      ①写入操作时,file可以不存在,若不存在,则创建这个文件
     *      ②创建FileWriter对象时,构造器有一个隐含参数append
     *          -若append为true,则追加数据
     *          -若appned为false,则覆盖数据
     *
     */
    @Test
    public void test3(){
        FileWriter fw = null;
        try {
            //1.创建File类对象,作为节点
            File file = new File("hi.txt");

            //2.将File对象作为构造参数创建FileWriter文件输出流
            fw = new FileWriter(file,false);

            //3.输出流进行写入操作
            fw.write("I have a dream!!");
            fw.write(97);
            fw.write("world peace",3,5);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.对FileWriter流进行关闭
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    /*
     * @Description  FileReader和FileWriter综合使用==>实现文件复制
     *  注:
     *  FileWriter FileReader属于节点流(文件流),适用于文本文件
     *  至于二进制文件,如图片,视频等,需要字节流
     */
    public void test4(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //srcFile必须存在,desFile可以不存在
            File srcFile = new File("hello1.txt");
            File desFile = new File("hello1.txt");

            //创建输入输出流,注意fw最好要设置为追加
            fr = new FileReader(srcFile);
            fw = new FileWriter(desFile, true);

            char[] cbuf = new char[5]; //读取字符数组
            int len ;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //输入输出流的关闭
            //错误写法
//            try {
//                if (fw != null && fr != null) {
//                    fr.close(); //如果这里出异常,fw不能关闭
//                    fw.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            try {
                if (fw!=null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("我还能执行");
            try {
                if (fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test5() {

    }
}
