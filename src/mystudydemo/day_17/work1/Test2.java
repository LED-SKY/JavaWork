package mystudydemo.day_17.work1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-28 20:12
 *  * 利用字节流去复制文本文件  图片文件  视频文件 (2种方式 单字节  多字节) 体会一下效率上的差别
 **/
public class Test2 {
    public static void main(String[] args) throws IOException {

        //一、单字节方式
        //文本文件复制
        FileInputStream inputTxt = new FileInputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\b.txt");
        FileOutputStream outText = new FileOutputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\copy_b.txt");
        int readData;
        long startTime1 = System.currentTimeMillis();
        while ((readData = inputTxt.read()) != -1) {
            outText.write(readData);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("文本文件复制结束，花费：" + (endTime1 - startTime1) + "ms");
        inputTxt.close();;
        outText.close();

        //图片文件复制
        FileInputStream inputImg = new FileInputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\1.jpg");
        FileOutputStream outImg = new FileOutputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\copy_1.jpg");
        int readData2;
        long startTime2 = System.currentTimeMillis();
        while ((readData2 = inputImg.read()) != -1) {
            outImg.write(readData);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("图片文件复制结束，花费" + (endTime2 - startTime2) + "ms");
        inputImg.close();
        outImg.close();

        //视频文件复制
        FileInputStream inputMp4 = new FileInputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\1.mp4");
        FileOutputStream outMp4 = new FileOutputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\copy_1.mp4");
        int readData3;
        long startTime3 = System.currentTimeMillis();
        while ((readData3 = inputMp4.read()) != -1) {
            outMp4.write(readData3);
        }
        long endTime3 = System.currentTimeMillis();
        System.out.println("视频文件复制结束，花费：" + (endTime3 - startTime3) + "ms");
        inputMp4.close();
        outMp4.close();
    }
}
