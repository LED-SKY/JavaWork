package mystudydemo.day_17.work4;

import java.io.*;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-28 21:21
 * 4.递归查找指定目录中(包括子目录中)，所有的.java文件，
 * 并且，把所有这些找到的java文件，复制(是复制不是移动)到一个指定的目录下
 **/
public class Test {

    public static void main(String[] args) throws IOException {
        File file = new File("G:\\BaiduDownload\\TestDir\\TestDirClone");
        copyJava(file);

    }
    public static boolean copyJava(File target) throws IOException {
        //获取目标目录下的所有文件的file对象
        File[] files = target.listFiles();

        if (files == null || files.length == 0) {
            return false;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                //进入到最深的文件夹
                copyJava(file);
            } else if (file.isFile() && file.getName().endsWith(".java")){
                //将指定后缀的文件，读取文件，然后将文件复制到指定文件夹的目录中
                FileInputStream in = new FileInputStream(file);
                File copyFile = new File("G:\\BaiduDownload\\TestDir\\" + file.getName());
                FileOutputStream out = new FileOutputStream(copyFile);
                int readData;
                byte[] bytes = new byte[1024];
                while ((readData = in.read(bytes))  != -1){
                    //写入
                    out.write(bytes);
                }
                in.close();
                out.close();
                
            }
        }

        return true;
        
    }
}
