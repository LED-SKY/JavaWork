package mystudydemo.day_16.work1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-27 22:53
 * 
 * 1.分别键盘输入文件名 和 文件内容，并按照文件名保存相应的内容
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String filePath = "G:\\BaiduDownload\\TestDir\\TestDirClone\\";
        System.out.println("请输入你要创建的文本文件的名字：");
        String textName = sc.nextLine();
       
        FileOutputStream f = new FileOutputStream(filePath + textName + ".text");
        System.out.println("请输入文件内容：");
        f.write((sc.nextLine()).getBytes());
        f.close();
    }
}
