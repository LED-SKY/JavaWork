package com.cskaoyan.javase.homework.day02;

import java.util.Scanner;

/**
 * @description: 根据键盘录入打印x行y列的井号
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class PrintWellDemo {

    public static void main(String[] args) {
        //键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个int参数作为打印的行数和列数，x是行数，y是列数");
        int x = sc.nextInt();
        int y = sc.nextInt();
        //调用方法
        printWell(x, y);
    }

    public static void printWell(int x, int y) {
        //嵌套for循环打印井号
        //外层控制行数
        //内层控制列数
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
