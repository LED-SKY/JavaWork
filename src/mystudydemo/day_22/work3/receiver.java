package mystudydemo.day_22.work3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @program: Stage1
 * @description: 接收端
 * @author: 邓造坚
 * @create: 2021-07-02 23:09
 **/
public class receiver {

    public static void main(String[] args) throws IOException {
        //创建用于接收端的socket对象
        DatagramSocket datagramSocket = new DatagramSocket(6666);
        //键盘录入
        Scanner scanner = new Scanner(System.in);
        while (true) {
            byte[] receiverBytes = new byte[1024];
            //创建用于接收数据的数据报包
            DatagramPacket receiverPacket = new DatagramPacket(receiverBytes, 0, receiverBytes.length);
            //receiver方法接收数据
            datagramSocket.receive(receiverPacket);

            //解析数据报包
            byte[] data = receiverPacket.getData();
            int offset = receiverPacket.getOffset();
            int length = receiverPacket.getLength();
            InetAddress address = receiverPacket.getAddress();
            //打印提示信息
            String receiverS = new String(data, offset, length);

            System.out.println("接收到来自" + address + "的信息" + receiverS);
            
           //创建用于发送的数据
            String msg = scanner.nextLine();
            byte[] bytes = msg.getBytes();
            //创建接收端的ip地址
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            //创建接收端的端口号
            int port = 5555;
            //创建用于发送的数据报包
            DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, ip, port);
            //send 方法发送数据
            datagramSocket.send(sendPacket);
            
        }
    }
}
