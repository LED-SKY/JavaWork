package mystudydemo.day_22.practice.udp.version2;

import mystudydemo.day_22.practice.udp.util.NetworkUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-02 15:24
 **/
public class Sender {
    public static void main(String[] args) throws IOException {
        //创建用于发送的socket 对象
        DatagramSocket datagramSocket = new DatagramSocket(1111);
        //创建用于发送的数据报包
        DatagramPacket sendPacket = NetworkUtils.getSendPacket("version 2 发送端", "127.0.0.1", 8888);
        
        //send方法发送数据报包
        datagramSocket.send(sendPacket);
        //close
        datagramSocket.close();
    }
}
