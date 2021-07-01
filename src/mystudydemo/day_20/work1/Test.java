package mystudydemo.day_20.work1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-30 15:23
 * <p>
 * **1.使用多线程实现方式一 ,多个文件一起复制功能，并在控制台显示复制的进度，进度以百分比表示。**
 * <p>
 * 例如：把文件A复制到E盘某文件夹下，在控制台上显示“XXX文件已复制xx%”，“XXX文件已复制xxx%”……“XXX文件已复制xxx%”，“XXX复制完成！”
 **/
public class Test {

    public static void main(String[] args) {
        ThreadCopyFile t1 = new ThreadCopyFile(new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\1.txt"), new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\copy_1.txt"));
        ThreadCopyFile t2 = new ThreadCopyFile(new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\2.txt"), new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\copy_2.txt"));
        ThreadCopyFile t3 = new ThreadCopyFile(new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\3.txt"), new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\copy_3.txt"));
        t1.start();
        t2.start();
        t3.start();
    }
}

class ThreadCopyFile extends Thread {
    public File startFile;
    public File endFile;

    public ThreadCopyFile() {
    }

    public ThreadCopyFile(File startFile, File endFile) {
        this.startFile = startFile;
        this.endFile = endFile;
    }

    @Override
    public void run() {
        try {
            FileInputStream in = new FileInputStream(startFile);
            FileOutputStream out = new FileOutputStream(endFile);
            byte[] bytes = new byte[300];
            //源文件长度
            long len = startFile.length();
            //实际读取长度
            int readLength = 0;
            //已读取进度
            double nowPercentage;
            //一次读取的长度
            int readCount;
            //设置输出百分率的格式
            DecimalFormat f = new DecimalFormat("0");
            while ((readCount = in.read(bytes)) != -1) {
                readLength += readCount;
                nowPercentage = (readLength * 1.0 / len) * 100;
                out.write(bytes);
                System.out.println("文件" + startFile.getName() + "已复制：" + f.format(nowPercentage) + "%");
        

            }
            System.out.println("文件" + startFile.getName() + "复制完成");
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            
        }

    }

}