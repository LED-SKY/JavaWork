package mystudydemo.day_16.practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-26 11:28
 * 字节输出流对象，将数据从内存输出到磁盘
 **/
public class Demo1 {
    public static void main(String[] args) throws IOException {
//        创建对象
        FileOutputStream out = new FileOutputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\a.txt");
//        写数据
        out.write(97);
        String s = "你好";
//        out.write(s.getBytes());
        byte[] bytes = s.getBytes();
//        out.write(s.getBytes(),0,s.getBytes().length);
        out.write(bytes,0,bytes.length);
        out.write(99);
        out.close();
        
    }      
    
}
