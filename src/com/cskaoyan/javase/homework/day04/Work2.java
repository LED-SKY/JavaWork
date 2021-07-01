package com.cskaoyan.javase.homework.day04;

/**
 * @description: 练习2
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Work2 {
    public static void main(String[] args) {
        System.out.println(getMaxValue(1, 2, 3, 324, 45, 999,23424,242435,342435));
    }

    public static int getMaxValue(int... values){
        int max = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max){
                max = values[i];
            }
        }
        return max;
    }
}
