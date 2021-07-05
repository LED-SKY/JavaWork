package mystudydemo.day_21.work2;

import java.io.*;
import java.text.DecimalFormat;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-01 21:12
 * 把文件A复制到E盘某文件夹下，在控制台上显示“XXX文件已复制xx%”，“XXX文件已复制xxx%”……“XXX文件已复制xxx%”，“XXX复制完成！”
 * 用多线程实现方式二去修改昨天的多线程文件复制
 **/
public class Test {
    public static void main(String[] args) {
        copyFile t1 = new copyFile(new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\1.txt"), new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\copy_1.txt"));
        copyFile t2 = new copyFile(new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\2.txt"), new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\copy_2.txt"));
        copyFile t3 = new copyFile(new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\3.txt"), new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\copy_3.txt"));
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}

class copyFile implements Runnable{

    private File  startFile ;
    private File  endFile ;

    public copyFile() {
    }

    public copyFile(File startFile, File endFile) {
        this.startFile = startFile;
        this.endFile = endFile;
    }

    @Override
    public void run() {
        try {
            FileInputStream in = new FileInputStream(startFile);
            FileOutputStream out = new FileOutputStream(endFile);
            byte[] bytes = new byte[100];
            //复制文件的总大小
            long len = startFile.length();
            //已经读取的文件大小
            long nowLen =0;
            //当前读取的文件进度
            double nowPercentage=0;
            //读取一次返回的文件的总字节数
            int readCount;
            //控制输出格式
            DecimalFormat f = new DecimalFormat("0");
            //通过输入流对象读取磁盘文件数据
            
            while ((readCount  = in.read(bytes))!=-1){
                //复制到输出流对象位置的文件中
                nowLen+=readCount;
                //计算进度
                nowPercentage = (nowLen * 1.0  /len)*100;
                out.write(bytes);
                System.out.println(startFile.getName() + "文件已复制：" + f.format(nowPercentage) + "%");
            }
            System.out.println(startFile.getName() + "复制完成，复制生成的文件为：" + endFile.getName() );
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}