package com.cskaoyan.javase.homework.day15;

/**
 * @description: 异常的练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

import java.util.Scanner;

/**
 * 接收键盘录入字符串，把该字符串转换成int数值，思考如果用户键入的不是int数值，用异常处理合理的提示用户，并使程序不会终止
 *
 */
public class Work1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个int数值：");

        String s = sc.nextLine();
        try {
            int i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            //模拟给用户发送通知
            System.out.println("您输入的不是一个int数值");
        }
        System.out.println("后面仍然正常执行");

    }

}
