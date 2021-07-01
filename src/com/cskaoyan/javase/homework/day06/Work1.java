package com.cskaoyan.javase.homework.day06;

/**
 * @description: 脑筋急转弯
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Work1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        method(a, b); //请自己写一个方法，输出“a = 100 , b = 200”
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static void method(int a, int b) {
        //必须依赖这个方法输出“a = 100 , b = 200”
        System.out.println("a = 100");
        System.out.println("b = 100");
        //我希望在这里程序立刻终止
        //return;
        //在这里直接退出虚拟机 干掉虚拟机
        System.exit(0); //该方法表示退出虚拟机
    }
}
