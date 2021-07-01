package mystudydemo.day_19.work2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-29 21:36
 * 加密算法：
 * 数字：
 * 如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4
 * 如果是9的数字，变成0
 * 字母字符：
 * 如果是非z字符，向右移动一个，比如d变成e, G变成H
 * 如果是z，z->a, Z-A。
 * 字符需要保留大小写
 * 非字母字符
 * 比如',&^ 保留不变，中文也保留不变
 **/
public class Test {

    public static void main(String[] args) throws IOException {
        File f1 = new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\1.txt");
        File f2 = new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\2.txt");
        encodeFile(f1, f2);

    }

    public static void encodeFile(File encodingFile, File encodedFile) throws IOException {
        FileInputStream in = new FileInputStream(encodingFile);
        FileOutputStream out = new FileOutputStream(encodedFile);
        byte[] bytes = new byte[1024];
        int readCount;
        while ((readCount = in.read(bytes)) != -1) {
            for (int i = 0; i < readCount; i++) {
                //判断是不是0-8的数字，是的话+1
                if (bytes[i] > 47 && bytes[i] < 57) {
                    bytes[i]++;
                    
                }else if(bytes[i] == 57){
                    //将9变成0
                    bytes[i] = 48;
                }
                //小写字母移位
                if (bytes[i] > 96 && bytes[i] < 122) {
                    bytes[i]++;

                }else if (bytes[i] == 122){
                    //将z变成a
                    bytes[i] = 97;
                }

                //大写字母移位
                if (bytes[i] > 64 && bytes[i] < 90) {
                    bytes[i]++;

                }else if (bytes[i] == 90){
                    //将Z变成A
                    bytes[i] = 65;
                }
            }
            out.write(bytes);

        }
        in.close();
        out.close();
    }
}
