package com.cskaoyan.javase.homework.day03;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: double数组的案例
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Work1Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //数组的长度是已知的，直接动态初始化
        double[] arr = new double[10];
        System.out.println("请连续输入10个学生的成绩：");
        for (int i = 0; i < 10; i++) {
            //连续接收10次 double数据
            double score = sc.nextDouble();
            //存入数组
            arr[i] = score;
        }

        //打印遍历这个数组，查看键盘录入的结果
        System.out.println(Arrays.toString(arr));

        //调用方法，求平均分
        double average = getAverage(arr);
        System.out.println("10个人的平均分是：" + average);
    }

    public static double getAverage(double[] arr) {
        double sumScore = 0;
        for (int i = 0; i < arr.length; i++) {
            sumScore += arr[i];
        }
        return sumScore / arr.length;
    }
}
