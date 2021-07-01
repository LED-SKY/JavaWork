package com.cskaoyan.javase.homework.day02;

import java.util.Scanner;

/**
 * @description: 作业3
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/


public class GradeDemo {
    public static void main(String[] args) {
        //键盘输入 三门学科成绩，然后，分别求出 三科成绩的平均分，最低分，最高分，三科的总分

        System.out.print("请输入三门课成绩：");
        Scanner sc = new Scanner(System.in);
        double score1 = sc.nextDouble();
        double score2 = sc.nextDouble();
        double score3 = sc.nextDouble();

        System.out.println("三门课平均成绩为：" + getAverage(score1, score2, score3));

        System.out.println("三门课中最高分" + getMaxScore(score1, score2, score3));

        System.out.println("三门课中最低分" + getMinScore(score1, score2, score3));

        System.out.println("三门课总和" + (score1 + score2 + score3));

    }

    //两次三目运算符求出最小值
    public static double getMinScore(double score1, double score2, double score3) {
        double tempMinScore = (score1 < score2) ? score1 : score2;
        return (tempMinScore < score3) ? tempMinScore : score3;
    }

    //两次三目运算符求出最大值
    public static double getMaxScore(double score1, double score2, double score3) {
        double tempMaxScore = (score1 > score2) ? score1 : score2;
        return (tempMaxScore > score3) ? tempMaxScore : score3;
    }

    //求平均值
    public static double getAverage(double score1, double score2, double score3) {
        return (score1 + score2 + score3) / 3;
    }


}

