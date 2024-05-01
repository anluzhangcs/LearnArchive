package demo;

/**
 * @author: zhanghao
 * @date: 2021/10/13-20:52
 */

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description IP 和 InetAddress
 *  -IP地址唯一标识一台主机:
 *      公网IP(一般能够访问的)
 *      私网IP(局域网内,192.168.0.0-192.168.255.255)
 *  -Java中对应IP的类是InetAddress
 *  -域名:IP地址的别名 域名 -> DNS域名解析服务器 -> IP地址
 *  -本地回环地址:127.0.0.1 localhost 代表主机
 *
 *  InetAddress
 *  -不能通过构造器创建
 *  常用方法:
 *      getByName(String host) 通过iP地址或域名来获取InetAddress对象
 *      getHostName()   直接获取主机InetAddress对象
 *
 *  端口号:一个进程对应一个端口
 *      公认端口:0~1023 被预先定义的通信服务所占用
 *      注册端口:1025~49151 可以被用户程序注册的端口 Tomcat(8080) Mysql(3306)
 *      私有端口:49152~65535
 *   -Ip地址和端口号组成一个套接字Socket,网络编程也就是Socket编程
 *
 */
public class IPTest {

    @Test
    public void test1() {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.16.1");
            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            InetAddress inet3 = InetAddress.getByName("localhost");
            InetAddress inet4 = InetAddress.getLocalHost();

            String hostName = inet2.getHostName(); //获取此ip地址的主机名
            String hostAddress = inet2.getHostAddress(); //获取此ip地址的ip

            System.out.println(hostName);
            System.out.println(hostAddress);

            //输出IP地址
            System.out.println(inet1);
            System.out.println(inet2);
            System.out.println(inet3);
            System.out.println(inet4);


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
