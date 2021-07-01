package mystudydemo.day_17.work2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-28 20:19
 * 2.读取一个文件，这个文件中有随机的一些数字字符，统计这些数字有几个偶数，几个奇数，并且追加写入到该文件末尾。
 * 例如：
 * a.txt文件：
 * 	3241256364789629090126581212515
 * 	奇数：xx个
 * 	偶数：xx个
 **/
public class Test {
    public static void main(String[] args) throws IOException {
//        FileInputStream in = new FileInputStream("G:\\BaiduDownload\\TestDir\\TestDirClobne\\a.txt");
//        FileOutputStream out = new FileOutputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\a.txt", true);
        FileInputStream in = new FileInputStream("english.txt");
        FileOutputStream out = new FileOutputStream("english.txt", true);
        byte[] bytes = new byte[1024];
        int readData;
        int odd = 0;
        int even = 0;
        int num = 0;
        while ((readData = in.read(bytes)) != -1){
            for (int i = 0; i < readData; i++) {
                num  = (int) bytes[i];
                if ((num %2)==0){
                    ++even;
                }else ++odd;
            }
        }
        out.write("\n".getBytes());
        out.write("奇数：".getBytes() );
        out.write((String.valueOf(odd) ).getBytes());
        out.write("个".getBytes() );


        out.write("\n".getBytes());
        out.write("偶数：".getBytes() );
        
        out.write((String.valueOf(even) ).getBytes());
        out.write("个".getBytes() );

        in.close();
        out.close();
    }
}
