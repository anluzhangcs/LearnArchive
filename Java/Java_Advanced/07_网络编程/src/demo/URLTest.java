package demo;

/**
 * @author: zhanghao
 * @date: 2021/10/14-20:23
 */

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Description URL编程
 *  URL:统一资源定位器,对应互联网上的某个资源
 *  url:http://localhost:8080/examples/servlets/
 *  格式:<传输协议>://<主机名>:<端口号>/<文件名>#片段名?参数列表
 *
 *  URL编程:
 *      URL类
 *      public String getProtocol( ) 获取该URL的协议名
 *      public String getHost( ) 获取该URL的主机名
 *      public String getPort( ) 获取该URL的端口号
 *      public String getPath( ) 获取该URL的文件路径
 *      public String getFile( ) 获取该URL的文件名
 *      public String getQuery( ) 获取该URL的查询名
 *
 */
public class URLTest {
    @Test
    public void test() {
        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            //1.创建URL对象
            URL url = new URL("http://localhost:8080/examples/servlets/index.html");

            //url常用方法
            System.out.println("getProtocol() :"+url.getProtocol());
            System.out.println("getHost() :"+url.getHost());
            System.out.println("getPort() :"+url.getPort());
            System.out.println("getPath() :"+url.getPath());
            System.out.println("getFile() :"+url.getFile());
            System.out.println("getQuery() :"+url.getQuery());

            //2.url打开连接获取连接之后connect()
            urlConnection =(HttpURLConnection) url.openConnection();
            urlConnection.connect();

            //3.获取读取流
            is = urlConnection.getInputStream();
            fos = new FileOutputStream("index.html");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
            //关闭连接
            urlConnection.disconnect();
        }

    }
}
