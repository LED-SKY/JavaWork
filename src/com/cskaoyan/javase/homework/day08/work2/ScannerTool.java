package com.cskaoyan.javase.homework.day08.work2;

/**
 * @description: 键盘录入工具类
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

import javax.swing.*;
import java.util.Scanner;

/**
 *
 * Scanner在做键盘录入时,建议不要混用next系列和nextLine方法
 * 否者会出现问题
 *
 * 工具类当中的Scanner实际上没有必要创建多个对象,全局使用一个对象就行了
 * 所以给出一个静态成员变量sc
 *
 */
public class ScannerTool {
    private static Scanner sc = new Scanner(System.in);

    private ScannerTool() {
    }

    public static String getStringByScanner() {
        System.out.println("请输入字符串：");
        return sc.nextLine();
    }

    public static int getIntByScanner() {
        System.out.println("请输入一个int整数：");
        return Integer.parseInt(sc.nextLine());
    }

    public static Person getPersonInstanceByScanner() {
        System.out.println("现在开始键盘录入一个Person对象！");
        System.out.println("请输入Person对象的name：");
        String name = sc.nextLine();
        System.out.println("请输入Person对象的age：");
        int age = Integer.parseInt(sc.nextLine());
        Person p = new Person(name, age);
        System.out.println("Person对象创建完毕！");
        return p;
    }

    public static Person[] getPersonArrByScanner(int length) {

        /*Person[] people = new Person[3];
        for (int i = 0; i < people.length; i++) {
            people[i].setAge(sc.nextInt());
            people[i].setName(sc.nextLine());
        }
        people[1].setAge(1);*/

        Person[] targetArr = new Person[length];
        System.out.println("现在开始为Person数组输入Person对象！");
        System.out.println("你总共需要输入" + length + "个Person对象！");
        for (int i = 0; i < targetArr.length; i++) {
            System.out.println("现在是输入第" + (i + 1) + "个Person对象！");
            targetArr[i] = getPersonInstanceByScanner();
        }
        System.out.println("Person数组输入完毕！");
        return targetArr;
    }

    public static void closeScanner(){
        sc.close();
    }
}
