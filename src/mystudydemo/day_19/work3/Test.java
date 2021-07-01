package mystudydemo.day_19.work3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-29 22:13
 * 解密算法：
 * 数字：
 * 如果不是0的数字，在原来的基础上减1，比如6变成5, 4变成3
 * 如果是0的数字，变成9
 * 字母字符：
 * 如果是非a字符，向左移动一个，比如e变成d, H变成G
 * 如果是a，a->z, A-Z。
 * 字符需要保留大小写
 * 非字母字符：
 * 比如',&^ 保留不变，中文也保留不变
 **/
public class Test {

    public static void main(String[] args) throws IOException {
        File f1 = new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\2.txt");
        File f2 = new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\3.txt");
        decodeFile(f1, f2);
    }

    public static void decodeFile(File decodingFile, File decodedFile) throws IOException {
        FileInputStream in = new FileInputStream(decodingFile);
        FileOutputStream out = new FileOutputStream(decodedFile);
        byte[] bytes = new byte[1024];
        int readCount;
        while ((readCount = in.read(bytes)) != -1) {
            for (int i = 0; i < readCount; i++) {
                //判断是不是1-9的数字，是的话-1
                if (bytes[i] > 48 && bytes[i] < 58) {
                    bytes[i]--;

                } else if (bytes[i] == 48) {
                    //将0变成9
                    bytes[i] = 57;
                }
                //小写字母移位
                if (bytes[i] > 97 && bytes[i] < 123) {
                    bytes[i]--;

                } else if (bytes[i] == 97) {
                    //将a变成z
                    bytes[i] = 122;
                }

                //大写字母移位
                if (bytes[i] > 65 && bytes[i] < 91) {
                    bytes[i]--;

                } else if (bytes[i] == 65) {
                    //将A变成Z
                    bytes[i] = 90;
                }
            }
            out.write(bytes);

        }
        in.close();
        out.close();

    }
}
