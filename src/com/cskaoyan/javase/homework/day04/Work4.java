package com.cskaoyan.javase.homework.day04;

/**
 * @description: 练习4
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 2，某公司该年度，每个季度的销售额（单位：万元）如下：
 * 第一季度：30,66, 44
 * 第二季度：10, 33, 20
 * 第三季度: 10,99,88
 * 第四季度: 9,18,25
 * 求：每个季度平均销售额 : 每个一维数组的平均值
 * 年度销售总额: 所有一维数组元素取值的和
 *
 * 实质上是一个长度是4的二维数组，直接静态初始化即可
 *
 */
public class Work4 {
    public static void main(String[] args) {
        //静态初始化二维数组，为了方便算平均值，有小数，用double类型二维数组
        double[][] arr = {{30, 66, 44}, {10, 33, 20}, {10, 99, 88}, {9, 18, 25}};
        getQuarterAverage(arr);
        sumYear(arr);
    }

    //获取季度的平均值，就是获取每个一维数组的平均值
    public static void getQuarterAverage(double[][] arr) {
        //遍历二维数组
        for (int i = 0; i < arr.length; i++) {
            //每个一维数组的初始和都是0，所以sum放这里
            double sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                //求和
                sum += arr[i][j];
            }
            //每个一维数组都有自己的平均值，所以在这里求
            System.out.println("第" + (i + 1) + "个季度的平均销售额是：" + (sum / 3));
        }
    }

    //获取年度销售总额，就是把二维数组每个元素都加起来
    public static void sumYear(double[][] arr) {
        //遍历二维数组
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println("全年销售额是：" + sum);

    }
}
