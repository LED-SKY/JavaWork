package mystudydemo.day_17.work3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-28 20:39
 * <p>
 * 在一个磁盘的文件里保存26个英文小写字母（乱序），将他们读入内存中，进行排序，把排好顺序的数再重新追加写到磁盘的该文件中。
 **/
public class Test {

    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\english.txt");
        FileOutputStream out = new FileOutputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\english.txt", true);
        byte[] bytes = new byte[26];
        int readData;
        
        while ((readData = in.read(bytes)) != -1) {
            Arrays.sort(bytes);
        }
        out.write("\n".getBytes());
        out.write(bytes);
        in.close();
        out.close();
        
       
        
    }
}
