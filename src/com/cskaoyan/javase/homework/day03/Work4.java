package com.cskaoyan.javase.homework.day03;

/**
 * @description: 第四题
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

import java.util.Arrays;

/**
 * 定义一个double类型的数组，让数组中每个元素（包括首位元素）都去除以首位元素，得到的结过作为该位置上的新元素
 * 该题尤其注意不能直接正序的遍历数组 然后除以第一个元素
 * 因为第一次除以后 首位元素已经改变了
 *
 * 考虑两种做法:
 *      1,把首位元素提取出来
 *      2,倒序遍历数组
 *      3，先从第二个元素开始除，第一个元素跳过，最后再除第一个
 *
 */
public class Work4 {
    public static void main(String[] args) {
        double[] arr = {2, 10, 16, 8, 7, 5, 15};
        modifyArrayByDividedFirstElement2(arr);
        System.out.println(Arrays.toString(arr));
    }

    //提取出首位元素
    public static void modifyArrayByDividedFirstElement(double[] arr) {
        double first = arr[0];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / first;
        }
    }

    //倒序遍历数组
    public static void modifyArrayByDividedFirstElement2(double[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = arr[i] / arr[0];
        }
    }
}
