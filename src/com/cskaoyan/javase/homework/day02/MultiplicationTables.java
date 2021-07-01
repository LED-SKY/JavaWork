package com.cskaoyan.javase.homework.day02;

import java.util.Scanner;

/**
 * @description: 根据键盘录入打印nn乘法表
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class MultiplicationTables {
    public static void main(String[] args) {
        //键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个int参数作为乘法表的阶数");
        int x = sc.nextInt();

        //调用方法
        printTable(x);
    }

    public static void printTable(int n) {
        //打印n行n列的九九乘法列
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + " = " + (i * j) + '\t');
            }
            System.out.println();
        }

    }
}
