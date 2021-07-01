package mystudydemo.day_16.work2;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.Scanner;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-27 23:07
 * 2.键盘输入文件名，文件内容，按照输入的文件名，文件内容保存。要求输入内容的时候可以多次追加写入，
 * 以一个约定字符串表示结束输出内容，比如当输入end时表示终止内容输入。
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String filePath = "G:\\BaiduDownload\\TestDir\\TestDirClone\\";
        System.out.println("请输入你要创建的文本文件的名字：");
        String textName = sc.nextLine();
        filePath += textName + ".txt";
        FileOutputStream f = new FileOutputStream(filePath,true);
        byte[] content ;
        String textContent ;
        while (true){
            System.out.println("请输入文件内容：");
            textContent = sc.nextLine();
            if (textContent.contains("end")){
//                匹配到"end"之前得到数据
               content =  textContent.substring(0,textContent.indexOf("end")).getBytes();
                f.write(content);
                System.out.println("结束追加");
                f.close();
                break;
            }
            content = textContent.getBytes();
            f.write(content);
            System.out.println("写入文件成功");
            f.close();

        }

    }
}
