package com.cskaoyan.javase.homework.day05;

/**
 * @description: 练习1，键盘录入二维数组
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

import java.util.Scanner;

/**
 *
 * 3，已知有3个班级（1到3班），分别有3人，2人，5人
 * 键盘录入每个班级的学生的成绩
 * 请使用二维数组存储数据
 * 计算每个班级的平均成绩，每个班级中的最高成绩和最低成绩，并输出
 *
 * 分析：这是一个二维数组，长度为3，但是每个一维数组长度不同，所以需要动态初始化，并且是格式二，灵活的方式
 *
 *
 */
public class Work1 {
    public static void main(String[] args) {
        //格式二动态初始化二维数组
        double[][] arr = new double[3][];
        //分别初始化其中的一维数组
        arr[0] = new double[3];
        arr[1] = new double[2];
        arr[2] = new double[5];
        //键盘录入成绩
        //遍历数组
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("请输入" + (i + 1) + "班第" + (j + 1) + "个同学的成绩：");
                //录入成绩
                arr[i][j] = sc.nextDouble();
            }
        }
        //System.out.println(Arrays.deepToString(arr));
        //double[][] arr2 = {{20, 30, 10}, {100, 90}, {10, 20, 30, 40, 50}};
        getClassAverage(arr);
        getClassMaxScore(arr);
        getClassMinScore(arr);
    }

    //计算每个班级的平均分，实际是计算每个一维数组的平均值
    public static void getClassAverage(double[][] arr) {
        //遍历二维数组
        for (int i = 0; i < arr.length; i++) {
            double sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            System.out.println((i + 1) + "班的平均分是：" + (sum / arr[i].length));
        }
    }

    public static void getClassMaxScore(double[][] arr) {
        //逐个遍历，然后求最大值
        for (int i = 0; i < arr.length; i++) {
            //设每个一维数组的第一个元素是最大值
            double max = arr[i][0];
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
            System.out.println((i + 1) + "班的最高分是：" + max);

        }
    }

    public static void getClassMinScore(double[][] arr) {
        //逐个遍历，然后求最小值
        for (int i = 0; i < arr.length; i++) {
            //设每个一维数组的第一个元素是最小值
            double min = arr[i][0];
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
            System.out.println((i + 1) + "班的最低分是：" + min);

        }
    }
}
