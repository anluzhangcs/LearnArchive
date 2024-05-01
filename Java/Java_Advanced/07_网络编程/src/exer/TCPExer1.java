package exer;

/**
 * @author: zhanghao
 * @date: 2021/10/14-17:00
 */

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description 客户端发送文件给服务端，服务端将文件保存在本地。
 */
public class TCPExer1 {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;

        try {
            //1.
            socket = new Socket("127.0.0.1", 8081);

            //2.
            os = socket.getOutputStream();
            fis = new FileInputStream("wangfei.jpg");
            byte[] data = new byte[1024];
            int len;
            while ((len = fis.read(data)) != -1) {
                os.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.
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
    public void server() {
        ServerSocket ss = null;
        Socket accept = null;
        FileOutputStream fos = null;
        InputStream is = null;
        try {
            //1.
            ss = new ServerSocket(8081);

            accept = ss.accept();

            fos = new FileOutputStream("wnafei2.jpg");
            is = accept.getInputStream();
            byte[] data = new byte[1024];
            int len;
            while ((len = is.read(data)) != -1) {
                fos.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {

                try {
                    is.close();
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
