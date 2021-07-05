package mystudydemo.day_22.practice.udp.version5;

import mystudydemo.day_22.practice.udp.util.NetworkUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-02 16:08
 * 
 * 发送任务
 * 
 **/
public class SendTask implements Runnable{

    //创建socket对象
    DatagramSocket datagramSocket;
    //发送到的ip
    String ip;
    //发送去的端口号
    int port;

    public SendTask(DatagramSocket datagramSocket, String ip, int port) {
        this.datagramSocket = datagramSocket;
        this.ip = ip;
        this.port = port;
    }

    public SendTask() {
    }

    @Override
    public void run() {
        //只干一件事，发送消息
        Scanner scanner = new Scanner(System.in);
        while (true){
            //从键盘接收数据
            String sendMsg = scanner.nextLine();
            //创建用于发送的数据报包
            try {
                DatagramPacket sendPacket = NetworkUtils.getSendPacket(sendMsg, ip, port);
                datagramSocket.send(sendPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
