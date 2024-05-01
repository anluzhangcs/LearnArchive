package exer;

/**
 * @author: zhanghao
 * @date: 2021/10/14-17:14
 */

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description 从客户端发送文件给服务端，服务端保存到本地。
 * 并返回“发送成功”给客户端。并关闭相应的连接。
 */
public class TCPExer2 {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建包含服务器IP和端口的套接字Socket
            socket = new Socket("127.0.0.1", 8081);

            //2.socket创建写入流
            os = socket.getOutputStream();

            //3.将传输的数据写入socket的输出流
            fis = new FileInputStream("wangfei.jpg");
            byte[] data = new byte[1024];
            int len;
            while ((len = fis.read(data)) != -1) {
                os.write(data, 0, len);
            }
            //注意:写入完成之后要关闭输出,否则服务器的read方法将一直执行
            //  因为不知道已经传输完了
            socket.shutdownOutput(); //重要

            //4.接收服务器端的反馈信息
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] bufferr = new byte[20];
            int len1;
            while((len1 = is.read(bufferr)) != -1){
                baos.write(bufferr,0,len1);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            if (baos != null) {

                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {

                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {

                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    //服务器端
    public void server() {
        ServerSocket ss = null;
        Socket accept = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream aos = null;
        try {
            //1.指定监听的接口
            ss = new ServerSocket(8081);

            //2.获取客户端的Socket套接字
            accept = ss.accept();

            //3.读取客户端传来的数据
            is = accept.getInputStream();
            fos = new FileOutputStream("wangfei2.jpg");
            byte[] data = new byte[1024];
            int len;
            while ((len = is.read(data)) != -1) {
                fos.write(data, 0, len);
            }
            System.out.println("图片传输成功");

            //4.反馈信息
            aos = accept.getOutputStream();
            aos.write("hi,client!你的请求信息我已收到".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            if (aos != null) {

                try {
                    aos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {

                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null) {

                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {

                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
