package com.cskaoyan.javase.homework.day03;

import java.util.Arrays;

/**
 * @description: String数组练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Work1Demo2 {
    public static void main(String[] args) {
        String[] arr = {"hello", "2", "world!"};
        System.out.println("数组的长度：" + arr.length);
        System.out.println("数组的第一个元素是" + arr[0]);
        System.out.println("数组的第二个元素是" + arr[1]);
        System.out.println("数组的第三个元素是" + arr[2]);

        //遍历
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
