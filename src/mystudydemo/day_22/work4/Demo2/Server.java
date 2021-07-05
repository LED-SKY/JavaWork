package mystudydemo.day_22.work4.Demo2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-03 09:07
 * 服务端
 * <p>
 * - 客户端键盘录入，服务器保存到文本文件中
 * - 客户端上传文本文件，服务器把内容输出到控制台
 * - 客户端上传文本文件，服务器保存文本文件
 **/
public class Server {
    public static void main(String[] args) throws IOException {

        //创建服务端的socket对象，绑定到特定端口的服务器套接字
        ServerSocket serverSocket = new ServerSocket(8888);
        //通过accept方法建立连接得到一个socket对象
        Socket client = serverSocket.accept();

            
        //获取输入流 通过read方法来读取客户端传输过来的数据
        InputStream in = client.getInputStream();
        //创建字节数组用来接收一次读取的数据
        byte[] bytes = new byte[1024];
        //一次读取的数据长度
        int readCount;
        //总的数据信息
        String s = "";
        while ((readCount = in.read(bytes)) != -1) {
            s += new String(bytes, 0, bytes.length);
        }
        //将信息存进本地文件,通过字符输出流 
        FileWriter uploadFile = new FileWriter("copy_client.txt", true);
        uploadFile.write(s);
        uploadFile.write(System.lineSeparator());
        uploadFile.flush();
        
        //客户端IP地址
        InetAddress ip = client.getInetAddress();
        System.out.println("接收到来自" + ip + "的信息，信息内容：" + s);

        //给客户端反馈消息
        //通过获取输出流将数据写入到返回的数据中
        OutputStream out = client.getOutputStream();
        out.write("服务器成功接收信息".getBytes());

        uploadFile.close();
    }

}
