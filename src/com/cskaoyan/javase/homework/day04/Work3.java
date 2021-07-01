package com.cskaoyan.javase.homework.day04;

/**
 * @description: 练习3
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * - 对于以上Java代码，可以把a，b的取值变为2倍吗？如果不能，为什么？
 *   不能,因为java只有值传递,方法获取的是实参的拷贝,方法不能改变原先实参的取值
 * - 请写代码完成：（完全重新写）
 *   - 使用方法，将两个元素（变量）变为它的2倍，并且输出它们
 *   思考: java只有值传递 基本数据类型的变量不可能通过方法变成2倍
 *   只能考虑用方法去修改对象的状态(对象中元素的取值)
 *   考虑使用数组
 *   使用方法将数组中的元素取值变成2倍是可以做得到的
 *
 *
 */
public class Work3 {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        doubleArrayElement(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }

    public static void doubleArrayElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2 * arr[i];
        }
    }
}
