package mystudydemo.day_22.work4.Demo2;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-03 09:06
 * <p>
 * 客户端
 * <p>
 * TCP连接
 * 
 * - 客户端上传文本文件，服务器把内容输出到控制台
 * - 客户端上传文本文件，服务器保存文本文件
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        //客户端录入数据
        //创建socket对象，用来将其连接到指定的主机上的端口号
        Socket socket = new Socket("127.0.0.1", 8888);
        
        //通过获取输出流，将本地文件数据写入到发送服务器端的数据中
        OutputStream out = socket.getOutputStream();
        //读取本地文件
        //字节输出流对象
        FileInputStream readIn = new FileInputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\1.txt");
        //一次读取文件的字节数
        int Count;
        //字节数组
        byte[] readBytes = new byte[1024];
        //边读边写
        while ((Count = readIn.read(readBytes)) != -1){
            out.write(readBytes,0,Count);
        }
        socket.shutdownOutput();

        //接收来自服务器端的反馈消息
        //获取输入流读取反馈信息
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readCount = in.read(bytes);
        String responseMsg = new String(bytes, 0, readCount);
        System.out.println(responseMsg);

    }

}

