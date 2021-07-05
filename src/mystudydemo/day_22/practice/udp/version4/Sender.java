package mystudydemo.day_22.practice.udp.version4;

import mystudydemo.day_22.practice.udp.util.NetworkUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @program: Stage1
 * @description: version 4
 * @author: 邓造坚
 * @create: 2021-07-02 15:44
 **/
public class Sender {

    public static void main(String[] args) throws IOException {
        //创建用于发送的socket对象
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        //键盘接收数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg;
        while ((msg = br.readLine()) != null){
            //把键盘输入的数据封装到数据报包里
            DatagramPacket sendPacket = NetworkUtils.getSendPacket(msg, "127.0.0.1", 9999);
            //用send方法发送出去
            datagramSocket.send(sendPacket);
            
            //以下是发送的接收
            //获取一个应用于接收的数据报包
            DatagramPacket receiverPacket = NetworkUtils.getReceiverPacket();
            datagramSocket.receive(receiverPacket);
            //解析数据报包
            String s =NetworkUtils.parsePacket(receiverPacket);
            System.out.println(s);
        }
    }
}
