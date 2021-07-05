package mystudydemo.day_22.practice.tcp.version3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-02 17:18
 **/
public class Client  {
    public static void main(String[] args) throws IOException {
        //创建客户端的socket对象
        //创建一个流套接字并将其连接到指定主机上的指定端口
        Socket socket = new Socket("127.0.0.1", 8888);
        //通过一个socket对象获取输出流，来写入数据，传到服务端
        OutputStream out = socket.getOutputStream();
        //通过输出流对象来写入数据
        out.write("TCP Connect".getBytes());
       
        //接收来自服务器的反馈消息
        //获取输入流
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readCount  =  in.read(bytes);
        String responeMsg = new String(bytes,0,readCount);
        System.out.println(responeMsg);
     
        
        socket.close();
        in.close();
        out.close();
    }
}
