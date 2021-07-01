package mystudydemo.day_17.practice;

import java.io.*;
import java.util.Date;

/**
 * @program: Stage1
 * @description: 复制图片
 * @author: 邓造坚
 * @create: 2021-06-28 15:00
 * 思路：
 * 先用BufferedInputStream读取文件的内容
 * 再用BufferedOutputStream写入到新文件当中
 * 注意要边读边写，因为一个byte数组的长度可能装不完文件的内容，这就需要读取一部分写入一部分
 **/
public class Demo4 {
    public static void main(String[] args) throws IOException {

        //计算复制时间
        long startTime = System.currentTimeMillis();
        String pathName = "G:\\BaiduDownload\\TestDir\\TestDirClone\\1.jpg";
        //创建输入流对象
        BufferedInputStream bff = new BufferedInputStream(new FileInputStream(pathName));
        //创建输出流对象

        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\2.jpg"));

        //读取数据 read
        byte[] bytes = new byte[1024];
        int readCount;
        //一定要边读边写
        while ((readCount = bff.read(bytes)) != -1) {
            out.write(bytes);
            //必须刷新才能存进去
        }
//        out.flush();
        long endTime = System.currentTimeMillis();
        if (new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\3.jpg").isFile()) {
            System.out.println("复制结束");
            System.out.println("用时：" + (endTime - startTime) + "ms");
        }
        bff.close();
        out.close();
    }
}
