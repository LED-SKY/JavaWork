package mystudydemo.day_16.practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: Stage1
 * @description: append为true将字节写入文件末尾处，不是从头开始写
 * @author: 邓造坚
 * @create: 2021-06-26 11:45
 **/
public class Demo2 {

    public static void main(String[] args) throws IOException {
        
        //创建输出流对象
        FileOutputStream out = new FileOutputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\b.txt", true);
//        FileOutputStream out = new FileOutputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\b.txt");
        out.write(99);
        out.close();

    }
}
