package mystudydemo.day_22.work3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @program: Stage1
 * @description: 发送端
 * @author: 邓造坚
 * @create: 2021-07-02 22:58
 **/
public class Sender {
    public static void main(String[] args) throws IOException {
        //创建发送端的socket对象
        DatagramSocket datagramSocket = new DatagramSocket(5555);
        //键盘录入发送的信息
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String msg = scanner.nextLine();
            //数据
            byte[] bytes = msg.getBytes();
            //接收端的ip
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            //接收端的端口号
            int port = 6666;
            //创建用于发送的数据报包
            DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, ip, port);
            datagramSocket.send(sendPacket);

            //接收数据
            //创建用于接收数据的字节数组
            byte[] receiverBytes = new byte[1024];
            //创建用于接收数据的数据报包
            DatagramPacket receiverPacket = new DatagramPacket(receiverBytes, 0, receiverBytes.length);
            //receiver方法接收数据
            datagramSocket.receive(receiverPacket);


            //解析数据
            byte[] data = receiverPacket.getData();
            int offset = receiverPacket.getOffset();
            int length = receiverPacket.getLength();
            InetAddress address = receiverPacket.getAddress();

            //打印接收后的数据
            String s = new String(data, offset, length);
            System.out.println("接收到来自" + address + "的数据信息" + s);
        }

    }
}
