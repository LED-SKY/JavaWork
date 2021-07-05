package mystudydemo.day_22.practice.udp.version3;

import mystudydemo.day_22.practice.udp.util.NetworkUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 * @program: Stage1
 * @description: 接收端
 * @author: 邓造坚
 * @create: 2021-07-02 15:10
 **/
public class Recevier {
    public static void main(String[] args) throws IOException {
        //创建接收的socket对象
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        while (true) {
            //创建用于接收的数据报包
            DatagramPacket receiverPacket = NetworkUtils.getReceiverPacket();
            //receive接收
            datagramSocket.receive(receiverPacket);
            //解析
            String s = NetworkUtils.parsePacket(receiverPacket);
            SocketAddress ip = receiverPacket.getSocketAddress();
            System.out.println("接收到了" + ip + "发送的" + s);
        }
    }
}
