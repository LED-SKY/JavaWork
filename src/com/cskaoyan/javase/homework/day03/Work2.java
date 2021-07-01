package com.cskaoyan.javase.homework.day03;

/**
 * @description: 求平均成绩
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 参加快乐男声比赛,有10个评委打分,(去掉一个最高一个最低)求最后的平均成绩
 * 提示：用数组装这些分数，并找到最大值和最小值去掉他们，然后算平均值。
 * 要求：必须提供三个方法：求最大值，最小值，平均分
 *
 */
public class Work2 {
    public static void main(String[] args) {
        //选择double去装分数，这样好计算平均分，所以用double数组
        double[] arr = {5, 8, 6, 7, 8, 9, 10, 10, 8, 8};
        System.out.println("平均分是："+getAverageScore(arr));
    }

    public static double getMaxScore(double[] arr) {
        //设置首元素是最大值
        double max = arr[0];
        //遍历数组，逐一比较，求最大值
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                //第一个元素不是最大值，所以max更新取值
                max = arr[i];
            }
        }
        return max;
    }

    public static double getMinScore(double[] arr) {
        //设置首元素是最小值
        double min = arr[0];
        //遍历数组，逐一比较，求最小值
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                //第一个元素不是最小值，所以max更新取值
                min = arr[i];
            }
        }
        return min;
    }

    public static double getAverageScore(double[] arr) {
        //先把数组所有元素加起来，然后减掉数组中的最大值和最小值，除以8
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double score = sum - getMaxScore(arr) - getMinScore(arr);
        return score / 8;
    }
}
