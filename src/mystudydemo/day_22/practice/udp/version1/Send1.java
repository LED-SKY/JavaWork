package mystudydemo.day_22.practice.udp.version1;

import java.io.IOException;
import java.net.*;

/**
 * @program: Stage1
 * @description: 网络编程_发送端
 * @author: 邓造坚
 * @create: 2021-07-02 14:39
 **/
public class Send1 {
    public static void main(String[] args) throws IOException {
        
        //来自应用层的数据
        String s = "我是你同桌";
        //创建用于发送端的UDP的socket对象,8888发送端口号
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        //创建用于发送的数报包
        byte[] bytes = s.getBytes();
        //接收IP地址
        InetAddress targetIp = InetAddress.getByName("127.0.0.1");
        //接收端口号
        int port = 9999;
        DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, targetIp, port);
        //send方法发送数据报包
        datagramSocket.send(sendPacket);
        //关闭资源
        datagramSocket.close();
    }

}
