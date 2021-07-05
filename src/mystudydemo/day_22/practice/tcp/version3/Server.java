package mystudydemo.day_22.practice.tcp.version3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: Stage1
 * @description: fuwuduan
 * @author: 邓造坚
 * @create: 2021-07-02 17:18
 **/
public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务端的socket对象 ServerSocket
        //创建绑定到特定端口的服务器套接字
        ServerSocket serverSocket = new ServerSocket(8888);
        //通过accept方法建立连接，得到一个socket对象
        Socket client = serverSocket.accept();
        //获取客户端发送来的数据，通过输入流来读取
        InputStream in = client.getInputStream();
        //通过输入流来读取数据
        byte[] bytes = new byte[1024];
        int readCount = in.read(bytes);
        String s = new String(bytes, 0, readCount);
        InetAddress ip = client.getInetAddress();
        System.out.println("接收到来自" + ip + "的消息" + s);
        //给客户端反馈消息
        //获取输出流
        OutputStream out = client.getOutputStream();
        out.write("收到了消息".getBytes());
        
        in.close();
        out.close();
    }
}
