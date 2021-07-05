package mystudydemo.day_22.practice.udp.version4;

import mystudydemo.day_22.practice.udp.util.NetworkUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-02 15:53
 **/
public class Receiver {
    public static void main(String[] args) throws IOException {
        
        //创建用于接收的socket对象
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //键盘接收数据
        Scanner sc = new Scanner(System.in);
        while (true){
            //创建用于接收的数据报包
            DatagramPacket receiverPacket = NetworkUtils.getReceiverPacket();
            //receiver
            datagramSocket.receive(receiverPacket);
            //解析数据报包
            String msg = NetworkUtils.parsePacket(receiverPacket);
            System.out.println(msg);
            //下面是给Sender发送消息
            //创建用于发送的数据报包，数据来源是键盘输入
            String s = sc.nextLine();
            DatagramPacket sendPacket = NetworkUtils.getSendPacket(s, "127.00.0.1", 8888);
            //send方法发送出去
            datagramSocket.send(sendPacket);
        }
    }
}
