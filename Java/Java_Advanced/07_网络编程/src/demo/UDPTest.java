package demo;

/**
 * @author: zhanghao
 * @date: 2021/10/14-18:43
 */

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Description UDP编程
 *  UDP协议:不可靠,无需建立连接,sender只管发,receiver能不能收到
 *
 *  UDP编程:
 *      -没有客户端和服务器之分,只有sender和receiver
 *      -sender和receiver都使用DatagramSocket
 *      -以数据报DatagramPacket传输
 *      -sender的socket不用指明ip和端口,receiver需要指明端口
 *
 *
 */
public class UDPTest {

    @Test
    public void sender() {
        DatagramSocket socket = null;
        try {
            //UDP编程使用DatagramSocket,发送方不需要指定ip和端口,这些都在数据报中指明
            socket = new DatagramSocket();

            //UDP使用UDP数据包的方式传输数据,且需指明ip和端口
            String str = "UDP数据包";
            byte[] data = str.getBytes();
            InetAddress inet = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet, 8081);

            //发送数据报
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            socket.close();
        }

    }

    @Test
    //接收方
    public void receiver() {
        DatagramSocket socket = null;
        try {
            //1.创建接收方的DatagramSocket,注意指明端口
            socket = new DatagramSocket(8081);

            //2.接收packetUDP数据报
            //相当与用packet去装接受的数据包,用byte[]装packet
            byte[] buffer = new byte[1024]; //注意这里的长度尽量大一点,要不然装不下
            DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
            socket.receive(packet);

            System.out.println(new String(packet.getData(),0,packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭资源
            socket.close();
        }


    }
}
