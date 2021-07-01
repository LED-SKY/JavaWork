package com.cskaoyan.javase.homework.day04.stage2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: 如何避免空指针异常
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 调用方法如果调用者是null 会产生空指针异常
 * 这个时候 为了避免空指针，最好它的调用者永远不是null
 *
 */

public class Problem2 {

    public static void main(String[] args) {
        String[] arr = new String[10];
        arr[0] = "123";
        arr[1] = "456";
        arr[2] = "789";
        System.out.println("修改前：" + Arrays.toString(arr));
        updateStudent(arr);
        System.out.println("修改后：" + Arrays.toString(arr));

        //equals方法具有对称性 左边和右边比还是右边和左边比都是一样的
        //java当中比较的方法有很多,但是不要认为每种比较的方法都具有对称性

    }

    public static void updateStudent(String[] studs) {
        //接收键盘录入，修改学生信息
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生信息：");
        String target = sc.nextLine();
        //遍历String数组，找到该学生信息
        for (int i = 0; i < studs.length; i++) {
            if (target.equals(studs[i])) {
                //找到需要修改的学生信息
                //键盘接收需要改成的取值
                System.out.println("已找到该学生！");
                System.out.println("请输入要修改成的学生信息：");
                String s = sc.nextLine();
                studs[i] = s;
                System.out.println("修改成功！");
                return;
            }
        }
        //执行完for循环没有结束方法，表示没有该学生信息
        System.out.println("无此学生！");
    }
}