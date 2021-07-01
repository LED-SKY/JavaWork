package com.cskaoyan.javase.homework.day08.work1;

/**
 * @description: test
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 12; i++) {
            System.out.println("创建的对象是：" + Student.getInstance());
        }
    }
}

