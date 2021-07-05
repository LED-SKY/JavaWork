package mystudydemo.day_22.practice.udp.version2;

import mystudydemo.day_22.practice.udp.util.NetworkUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @program: Stage1
 * @description: 版本二的接收端
 * @author: 邓造坚
 * @create: 2021-07-02 15:19
 **/
public class Recevier {
    public static void main(String[] args) throws IOException {
        //创建用于接收的socket对象
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        //创建用于接收的数据报包
        DatagramPacket receiverPacket = NetworkUtils.getReceiverPacket();
        //receive方法接收
        datagramSocket.receive(receiverPacket);
        //解析
        String msg = NetworkUtils.parsePacket(receiverPacket);
        System.out.println(msg);
        //close
        datagramSocket.close();
    }
}
