package mystudydemo.day_17.practice;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-28 11:15
 **/
public class Demo2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream f = new FileOutputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\d.txt");
        f.write(99);
        f.write(97);
        f.close();
    }
}
