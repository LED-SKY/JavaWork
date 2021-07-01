package mystudydemo.day_19.practice;

import java.util.Scanner;

/**
 * @program: Stage1
 * @description: 进程和线程的创建
 * @author: 邓造坚
 * @create: 2021-06-29 17:16
 **/
public class Demo1 {
    public static int num  = 6;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         
        
        new Thread(){
            @Override
            public void run() {
                while (num-- > 0){
                    System.out.println("线程一——————————————");
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {

                while (num-- > 0){
                    System.out.println("线程二");
                }
            }
        }.start();
    }
}
