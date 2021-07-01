package com.cskaoyan.javase.homework.day01;

import java.util.Scanner;

/**
 * @description: day01作业第1道题
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 *  键盘输入某个学生的三门学科（数学，语文，英语）成绩，然后分别求出三科成绩的平均分，最低分，最高分，三科的总分
 */
public class Work1 {
    public static void main(String[] args) {
        System.out.print("请输入三门课成绩：");
        Scanner sc = new Scanner(System.in);
        double mathScore = sc.nextDouble();
        double chineseScore = sc.nextDouble();
        double englishScore = sc.nextDouble();

        //double aveScore = (mathScore + chineseScore + englishScore) / 3;
        System.out.println("三门课平均成绩为：" + ((mathScore + chineseScore + englishScore) / 3));

        //两次三目运算符求出最大值
        double tempMaxScore = (mathScore > chineseScore) ? mathScore : chineseScore;
        double maxScore = (tempMaxScore > englishScore) ? tempMaxScore : englishScore;
        System.out.println("三门课中最高分" + maxScore);

        //两次三目运算符求出最小值
        double tempMinScore = (mathScore < chineseScore) ? mathScore : chineseScore;
        double minScore = (tempMinScore < englishScore) ? tempMinScore : englishScore;
        System.out.println("三门课中最低分" + minScore);


        System.out.println("三门课总和" + (mathScore + chineseScore + englishScore));

    }
}
