package mystudydemo.day_18.practice;

import java.io.*;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-29 11:34
 **/
public class Demo1 {
    public static void main(String[] args) throws IOException {
        
        //乱码，write方法将数据的高24位被忽略，低8位写入
/*        FileOutputStream out = new FileOutputStream("english.txt");
        out.write(98);
        out.close();*/

//        用数据输出流对象
        DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("english.txt"));
        dataOut.writeInt(10);
        dataOut.writeInt(20);
        dataOut.writeBoolean(true);
        dataOut.writeDouble(3.14);
        dataOut.close();
        //还是乱码，因为编码表中没有与java数据类型对应的编码，但是可以通过DataInputStream来验证
        DataInputStream dataIn = new DataInputStream(new FileInputStream("english.txt"));
        //必须按顺序，匹配正确的类型来读取数据，不然会出错，因为内存中这些数据是连在一起的，是按照占的字节个数来读取的
        int a = dataIn.readInt();
        int b = dataIn.readInt();
//        double c = dataIn.readDouble();
        System.out.println(a);
        System.out.println(b);
//        System.out.println(c);
    }
}
