package io;

/**
 * @author: zhanghao
 * @date: 2021/10/12-13:08
 */

import org.junit.Test;

import java.io.*;


/**
 * @Description 其他流的使用
 *  1.标准输入输出流
 *      System.in 默认从键盘输入
 *          public final static InputStream in
 *      System.out 默认输出到控制台
 *          public final static PrintStream out
 */
public class OtherStreamTest {

    @Test
    /*
     * @Description  打印流 PrintStream PrintWriter
     *  作用:将基本数据类型转化为字符串输出
     *  方法:就是各种重载的println,print方法
     *  注意:
     *      -System.out会返回一个PrintStream的实例
     *      -System.out默认输出是控制台,可以通过System.setOut(PrintStream ps)修改
     *      -PrintStream和PrintWriter有自动flush功能
     *
     *  应用:将0-255的ascii码输出到文件中而不是控制台
     */
    public void test1() throws UnsupportedEncodingException {

        PrintStream ps = null;
        try {
            //创建打印流


            ps = new PrintStream(new FileOutputStream("ascii.txt"),true,"gbk");
            System.setOut(ps);//重新设置输出流
            for (int i = 0; i < 255; i++) {
                System.out.print((char)i);
                if (i % 50 == 0 && i != 0) {
                    System.out.println();

                }
            }
            System.out.print("jb张豪彻底恢复");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {

                ps.close();
            }
        }

    }

    @Test
    /*
     * @Description  数据流
     *  DataInputStream 读取基本数据类型和字符串
     *  DataOutputStream 写入基本数据类型和字符串
     */
    public void test2() {
        DataInputStream dis = null;
        DataOutputStream dos = null;

        try {
            //1.创建数据流
//            dis = new DataInputStream(new FileInputStream("dos.txt"));
            dos = new DataOutputStream(new FileOutputStream("dos.txt"));
//
//            //2.先进行将基本数据类型写入操作
            dos.writeUTF("你好");
            dos.writeBoolean(true);
            dos.flush();//可以显式调用flush方法写入文件

            //3.读取数据
//            System.out.println(dis.readUTF());
//            System.out.println(dis.readBoolean());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            if (dos != null) {

                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (dis != null) {

                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void test4() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("ascii.txt"));

            pw.write("zhangsan");
            pw.write("咋解释");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {

                pw.close();
            }
        }

    }

}


