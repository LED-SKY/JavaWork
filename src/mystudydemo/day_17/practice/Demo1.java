package mystudydemo.day_17.practice;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-28 10:08
 * 读取数据步骤
 * 1.创建字节输入流对象
 * 2.read方法读取数据
 * 3.close关闭对象
 **/
public class Demo1 {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("G:\\BaiduDownload\\TestDir\\TestDirClone\\b.txt");
        byte[] bytes = new byte[7];

/*
//       返回当前读取数据的ASCII值
//        读入第一个字符
        int readCount1 = in.read();
//        读入第二个字符
        int readCount2 = in.read();
        System.out.println(readCount2);
        //返回文件的总长度
//        读入第三个字符之后的全部字符
        int readCount = in.read(bytes);
        System.out.println(readCount);
*/
//      方式一
/*        int readDate;
        while (true){
            readDate = in.read();
            if (readDate == -1){
                break;
            }else {
                System.out.print(((char) readDate));
            }
        }*/
//   方式二 推荐
/*        int readDate;
        while ((readDate  = in.read())!=-1){
            System.out.print(((char) readDate));
        }*/
//     方式三 多字节读取，推荐
//        两步，一是读取出字符总长度，进入内部输出，二是再读取一次返回-1退出循环
        int readCount;
        while ((readCount = in.read(bytes))!=-1){
            System.out.println(readCount);
            System.out.println(new String(bytes,0,readCount));
        }
        System.out.println(readCount = in.read(bytes));
        in.close();
    }

}
