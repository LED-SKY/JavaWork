package mystudydemo.day_17.practice;

import java.io.*;

/**
 * @program: Stage1
 * @description: 缓冲输入流对象，用于读取数据
 * @author: 邓造坚
 * @create: 2021-06-28 14:45
 **/
public class Demo3 {

    public static void main(String[] args) throws IOException {
        String   pathName = "G:\\BaiduDownload\\TestDir\\TestDirClone\\d.txt";
        //创建输入流对象
        BufferedInputStream bff = new BufferedInputStream(new FileInputStream(pathName));
        //读取数据 read
        byte[] bytes = new byte[1024];
        int readCount = bff.read(bytes);
        System.out.println(new String(bytes,0,readCount));

        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\dd.txt"));
        out.write(bytes);
        //必须刷新才能存进去
        out.flush();
        bff.close();
    }
}
