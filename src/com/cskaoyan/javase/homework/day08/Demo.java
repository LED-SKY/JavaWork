package com.cskaoyan.javase.homework.day08;

import java.util.Scanner;

/**
 * @description: Scanner的使用细节
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*int age= sc.nextInt();
        String name = sc.nextLine();
        System.out.println(age);
        System.out.println(name);*/

        for (int i = 0; i < 10; i++) {
            String s = sc.nextLine();
            System.out.println(s);
            int a = sc.nextInt();
            System.out.println(i);
        }

    }
}
