package mystudydemo.day_22.practice.udp.version1;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-02 14:46
 **/
public class Receiver1 {
    public static void main(String[] args) throws IOException {
        //创建用于接收的UDP的socket对象
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        while (true){
            //创建用于接收的数据报包
            byte[] bytes = new byte[1024];
            DatagramPacket receiverPacket = new DatagramPacket(bytes, 0, bytes.length);
            //receiver方法接收数据报包
            System.out.println("receiver before");
            datagramSocket.receive(receiverPacket);
            System.out.println("receiver after");

            //解析数报包
            //数据在报包里
            byte[] data = receiverPacket.getData();
            int offset = receiverPacket.getOffset();
            int length = receiverPacket.getLength();
            System.out.println(new String(data, offset, length)); 
        }
     
        
    }
}
