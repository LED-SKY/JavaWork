package mystudydemo.day_22.work2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-02 23:36
 * **用Callable的方式去实现之前的多线程文件复制**
 * <p>
 * 复制成功后,返回复制成功的文件路径,并利用Callable的方式接收返回值,然后把这几个路径都保存到新的文件中.
 **/
public class Test {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        //创建FutureTask
        FutureTask<File> f1 = new FutureTask<File>(new MyThread(new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\1.txt"), new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\copy_1.txt")));
        FutureTask<File> f2 = new FutureTask<File>(new MyThread(new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\2.txt"), new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\copy_2.txt")));
        FutureTask<File> f3 = new FutureTask<File>(new MyThread(new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\3.txt"), new File("G:\\BaiduDownload\\TestDir\\TestDirClone\\copy_3.txt")));
        //创建三个线程并启动
        Thread t1 = new Thread(f1);
        Thread t2 = new Thread(f2);
        Thread t3 = new Thread(f3);
        //启动线程
        t1.start();
        t2.start();
        t3.start();
        //获取call方法返回值
        File file1 = f1.get();
        File file2 = f2.get();
        File file3 = f3.get();
        //创建一个输出流对象，将复制文件的路径存入磁盘文件中
        FileOutputStream out = new FileOutputStream("copyPath.txt");
        out.write(file1.getAbsolutePath().getBytes());
        out.write("\n".getBytes());
        out.write(file2.getAbsolutePath().getBytes());
        out.write("\n".getBytes());
        out.write(file3.getAbsolutePath().getBytes());
        out.write("\n".getBytes());
        out.close();
    }
}

class MyThread implements Callable {

    File startFile;
    File endFile;

    public MyThread(File startFile, File endFile) {

        this.startFile = startFile;
        this.endFile = endFile;
    }

    public MyThread() {
    }

    @Override
    public Object call() throws Exception {
        //文件输入输出流对象，用于将文件读取到内存中再写入到新的文件中
        FileInputStream in = new FileInputStream(startFile);
        FileOutputStream out = new FileOutputStream(endFile);
        //字节数组，用来保存每次读取的数据
        byte[] bytes = new byte[1024];
        //单次读取的数据长度
        int readCount;
        while ((readCount = in.read(bytes)) != -1) {
            out.write(bytes);
        }
        System.out.println(Thread.currentThread().getName() + "线程复制文件：" + startFile.getName() + "成功");
        in.close();
        out.close();
        return endFile;
    }
}