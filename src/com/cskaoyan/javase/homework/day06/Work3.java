package com.cskaoyan.javase.homework.day06;

import java.util.Scanner;

/**
 * @description: 作业3
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Work3 {
    public static void main(String[] args) {
        //键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数，范围在1-100之间：");
        //Math.random()方法获取一个0~1的小数，左闭右开[0,1)
        //new Random()
        //Math.random()*100强转int舍弃小数位，表示 [0,100)的整数
        //(int) (Math.random() * 100) + 1 表示 [1,100]之间的整数
        int guessNum = (int) (Math.random() * 100) + 1;
        //因为要猜很多次，所以用死循环
        boolean flag = true;
        while (flag) {
            //接受键盘录入 猜数
            int result = sc.nextInt();
            if (result < guessNum) {
                //猜小了
                System.out.println("小了");
            } else if (result > guessNum) {
                //猜大了
                System.out.println("大了");
            } else {
                //猜对了
                System.out.println("猜对了");
                flag = false; //退出循环
            }
        }
    }
}
