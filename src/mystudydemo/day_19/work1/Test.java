package mystudydemo.day_19.work1;

import java.io.*;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-29 20:57
 * .利用字符流去读取一个文本文件，每次读取一行，并将这行数据逆序，写入新的文本文件当中**
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        //创建缓冲字符输入流对象
        BufferedReader in = new BufferedReader(new FileReader("G:\\BaiduDownload\\TestDir\\TestDirClone\\b.txt"));
        //创建缓冲字符输出流对象
        BufferedWriter out = new BufferedWriter(new FileWriter("G:\\BaiduDownload\\TestDir\\TestDirClone\\newb.txt"));
        //line保存读取的一行的字符串
        String line;
        while ((line = in.readLine()) !=null){
            //将字符串转换为StringBuffer类型，方便调用其的翻转字符串方法
            StringBuffer sb = new StringBuffer(line);
            //接受翻转后的字符串
            String temp = sb.reverse().toString();
            //写入磁盘
            out.write(temp);
            //写入换行符
            out.write(System.lineSeparator());
        }
        //关闭
        in.close();
        out.close();
    }
}
