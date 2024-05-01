package demo;

/**
 * @author: zhanghao
 * @date: 2021/10/14-11:47
 */

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description 方面2之TCP编程
 *
 * TCP协议:属于传输层协议,点对点,可靠,传输效率低.
 *      建立连接(三次招手)-->传输数据-->释放连接(四次挥手)
 *
 */
public class TCPTest {

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建服务器端ServerSocket,创建时指定端口号,监听来自客户端的请求
            ss = new ServerSocket(8081);

            //2.接收来自客户端的Socket
            accept = ss.accept();

            //3.用accpet创建输入流读出客户端传来的数据
            is = accept.getInputStream();

            //4.使用InputStream读取数据
            byte[] bytes = new byte[5];
            int len;
            //方式1 (不推荐)
//        while ((len = is.read(bytes)) != -1) {
//            //注意:如果传输的数据中有汉字,byte[]数组比较小,很有可能乱码
//            System.out.println(new String(bytes, 0, len));
//        }

            //方式2 使用ByteArrayOutputStream
            baos = new ByteArrayOutputStream();
            while ((len = is.read(bytes)) != -1) {
                //将字节数组储存到底层字节数组中
                baos.write(bytes, 0, len);
            }
            System.out.println(baos.toString());
            //获取收到套接字的ip对象,即IP地址
            System.out.println(accept.getInetAddress());
            //获取收到套接字的本地端口
            System.out.println(accept.getLocalPort());
            System.out.println(ss.getInetAddress());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源 流,Socket套接字等
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

    @Test
    //创建客户端
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.创建客户端套接字
            //用服务器的IP地址创建IP对象
            InetAddress inet = InetAddress.getByName("localhost");
            //用服务器IP地址和端口创建套接字Socket
//            socket = new Socket(inet, 8081);
            socket = new Socket("10.147.250.7", 8081);

            //2.使用套接字创建输出流并写入数据
            os = socket.getOutputStream();

            //3.写入要传输的数据
            os.write("你好,我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
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
}
