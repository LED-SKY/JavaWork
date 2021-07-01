package com.cskaoyan.javase.homework.day07.stage3.utils;


import com.cskaoyan.javase.homework.day07.stage3.entity.Student;
import com.cskaoyan.javase.homework.day07.stage3.entity.StudentList;

import java.util.Scanner;

/**
 * @description: 键盘录入工具类
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class ScannerUtils {
    //需要一个Scanner对象,用来做键盘录入,用static修饰保证该对象唯一
    private static final Scanner sc = new Scanner(System.in);

    //私有化构造方法
    private ScannerUtils() {
    }


    /*//根据键盘录入,封装成一个Student对象并返回
    public static Student getStudentInstanceByScanner() {
        //为了避免Scanner有异常错误,全部采用nextLine()接收字符串,然后转换类型
        System.out.print("请输入要录入学生的学号：");
        String tempStringStuId = sc.nextLine();
        int stuId = Integer.parseInt(tempStringStuId);
        System.out.print("请输入要录入学生的姓名：");
        String name = sc.nextLine();
        System.out.print("请输入要录入学生的性别：");
        String gender = sc.nextLine();
        System.out.print("请输入要录入学生的班级：");
        String grade = sc.nextLine();
        System.out.print("请输入要录入学生的年龄：");
        String tempStringAge = sc.nextLine();
        int age = Integer.parseInt(tempStringAge);
        System.out.print("请输入要录入学生的电话号码：");
        String phoneNum = sc.nextLine();

        //创建对象,并返回
        return new Student(stuId, name, gender, grade, age, phoneNum);
    }*/

    //根据键盘录入,封装成一个Student对象并返回，但是要对学号做唯一性校验
    //需要传入使用的StudentList对象，进行校验
    public static Student getStudentInstanceByScanner(StudentList sls) {
        //为了避免Scanner有异常错误,全部采用nextLine()接收字符串,然后转换类型
        System.out.print("请输入要录入学生的学号：");
        String tempStringStuId = sc.nextLine();
        int stuId = Integer.parseInt(tempStringStuId);
        //调用成员方法来判断stuId是否重复
        if (!sls.judgeStuIdLegal(stuId)) {
            //不允许学号重复，如果重复返回null
            return null;
        }
        System.out.print("请输入要录入学生的姓名：");
        String name = sc.nextLine();
        System.out.print("请输入要录入学生的性别：");
        String gender = sc.nextLine();
        System.out.print("请输入要录入学生的班级：");
        String grade = sc.nextLine();
        System.out.print("请输入要录入学生的年龄：");
        String tempStringAge = sc.nextLine();
        int age = Integer.parseInt(tempStringAge);
        System.out.print("请输入要录入学生的电话号码：");
        String phoneNum = sc.nextLine();

        //创建对象,并返回
        return new Student(stuId, name, gender, grade, age, phoneNum);
    }

    public static int getStuIdByScanner() {
        System.out.println("请输入要录入的学号：");
        return Integer.parseInt(sc.nextLine());
    }

    public static int getMenuByScanner(){
        return Integer.parseInt(sc.nextLine());
    }

    public static int getFlagByScanner() {
        return Integer.parseInt(sc.nextLine());
    }
}
