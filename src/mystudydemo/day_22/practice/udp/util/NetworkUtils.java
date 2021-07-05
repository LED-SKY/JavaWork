package mystudydemo.day_22.practice.udp.util;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/**
 * @program: Stage1
 * @description: 工具类
 * @author: 邓造坚
 * @create: 2021-07-02 14:57
 **/
public class NetworkUtils {
    public static void main(String[] args) {

    }

    //获取发送端数据报包的方法
    public static DatagramPacket getSendPacket(String msg, String ip, int port) throws UnknownHostException {
        //把需要发送的数据转化为字节数组
        byte[] bytes = msg.getBytes();
        InetAddress targetIp = InetAddress.getByName(ip);
        //创建用于发送的数据报包
        DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, targetIp, port);
        return sendPacket;
    }

    //获取用于接收的数据报包的方法
    public static DatagramPacket getReceiverPacket() {
        byte[] bytes = new byte[1024];
        DatagramPacket recevierPacket = new DatagramPacket(bytes, 0, bytes.length);
        return recevierPacket;
    }

    //解析数据报包的方法
    public static String parsePacket(DatagramPacket packet) {
        byte[] data = packet.getData();
        int offset = packet.getOffset();
        int length = packet.getLength();
        SocketAddress ip = packet.getSocketAddress();
        String s = new String(data, offset, length);
        s = "接收到来自" + ip + "发送的" + s;
        return s;
    }
}
