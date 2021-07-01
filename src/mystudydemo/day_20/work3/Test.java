package mystudydemo.day_20.work3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-30 17:00
 * 要求: 从0-9这10个数中
 * <p>
 * - 生成一个长度是3的随机数字，把这个字符串当作密码
 * - 创建一个破解线程，使用穷举法，匹配这个密码,直到匹配到正确的
 * - 创建一个日志线程，将用过的字符串写入文件，这个日志线程设计为守护线程
 **/
public class Test {
    public static String password = "023";
    public static String[][][] logPadArr = new String[10][10][10];

    public static void main(String[] args) {

        LogThread logThread = new LogThread();
        logThread.setDaemon(true);
        logThread.start();
        new Thread(){
            @Override
            public void run() {
                //拼接一个穷举的密码的字符串
                StringBuffer s = new StringBuffer();
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        for (int k = 0; k < 10; k++) {
                            s.append(i);
                            s.append(j);
                            s.append(k);
                            System.out.print(s + ",");
                            //写入进LogThread线程当中
                            logPadArr[i][j][k] = s.toString();
                            logThread.setLogPad(s.toString());
                            logThread.setFile();
                            if (s.toString().equals(password)) {
                                System.out.println();
                                System.out.println("匹配成功了");
                                return;
                            }

                            s.delete(0, s.length());

                        }
                    }
                }
            }
        }.start();
      
    }

}
//写入文件
class LogThread extends Thread {
    private String logPad;

    @Override
    public void run() {
        System.out.println("LogThread 开始");

    }
    //获得存储容器的内容
    public void setLogPad(String s) {
        this.logPad = s;
    }
//    将内容写入文件当中
    public void setFile(){
        BufferedWriter out =  null;
        try {
            out = new BufferedWriter(new FileWriter("logPassword.txt",true));
            out.write(logPad + ",");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
class CrackThread extends Thread {
    //获取密码
    private String pad;
    //保存用过的密码
    public static String[][][] logPadArr = new String[10][10][10];

    @Override
    public void run() {
     
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    s.append(i);
                    s.append(j);
                    s.append(k);
                    System.out.print(s + ",");

                    logPadArr[i][j][k] = s.toString();
                    
                    if (s.toString().equals(pad)) {
                        System.out.println();
                        System.out.println("匹配成功了");
                        return;
                    }

                    s.delete(0, s.length());

                }
            }
        }


    }

    public void setPad(String pad) {
        this.pad = pad;
    }

    public static void setLogPadArr(String[][][] logPadArr) {
        CrackThread.logPadArr = logPadArr;
    }

    public  String[][][] getLogPadArr() {
        return logPadArr;
    }
}*/
