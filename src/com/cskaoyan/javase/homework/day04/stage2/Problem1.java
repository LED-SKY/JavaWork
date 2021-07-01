package com.cskaoyan.javase.homework.day04.stage2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: 问题一：插入成功，但是打印不到元素
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/


public class Problem1 {
    public static void main(String[] args) {
        start();
    }

    private static void showMenu() {
        System.out.println("\n-----------------王道Java学生管理系统-----------------\n");
        System.out.println("                   1.学 生 列 表");
        System.out.println("                   2.增 加 学 生");
        System.out.println("                   3.删 除 学 生");
        //怎么比较字符串相等 equals方法
        System.out.println("                   4.修 改 学 生");
        System.out.println("                   5.查 询 学 生");
        System.out.println("                   6.退 出 系 统\n");
        System.out.print("请选择功能(1-6)：");
    }

    public static void start() {

        //声明一个String数组，用一个字符串（name）来表示一个学生
        String[] studs = new String[10];
        //预先放三个元素
        studs[0] = "张三";
        studs[1] = "李四";
        studs[2] = "长风";

        //该标志指示循环是否继续进行,即是否仍然输出菜单
        boolean loopFlag = true;
        while (loopFlag) {

            //System.out.println(Arrays.toString(studs));

            //调用方法,输出菜单
            showMenu();
            //键盘录入 选择对应功能
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    //输出学生列表，实质是遍历String数组
                    //调用这个遍历方法，该方法需要传入数组，作为数据源
                    printStudent(studs);
                    break;
                case 2:
                    //增加学生信息，是在null的位置放入一个新的字符串
                    createStudent(studs);
                    break;
                case 3:
                    //删除学生信息是将数组中的元素改成null
                    deleteStudent(studs);
                    break;
                case 4:
                    //找到这个学生，然后修改
                    updateStudent(studs);
                    break;
                case 5:
                    //简单实现一下查找，该方法会打印该学生信息在数组中的下标
                    retrieveStudent(studs);
                    break;
                case 6:
                    System.out.println("确认退出吗（1/2）：");
                    int quitFlag = sc.nextInt();
                    if (quitFlag == 1) {
                        loopFlag = false;
                        System.out.println("感谢使用本系统！");
                    }
                    break;
            }
        }
    }

    public static void retrieveStudent(String[] studs) {
        //接收键盘录入，要查询的学生信息
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的学生信息：");
        String target = sc.nextLine();
        //目标下标，默认值是-1
        int targetIndex = -1;
        for (int i = 0; i < studs.length; i++) {
            if (target.equals(studs[i])) {
                //找到该学生信息，目标下标等于i
                targetIndex = i;
            }
        }
        if (targetIndex == -1) {
            //表示未找到该学生信息
            System.out.println("查无此人！");
        } else {
            //找到了
            System.out.println("该学生信息在String数组中的下标是：" + targetIndex);
        }
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

    public static void deleteStudent(String[] studs) {
        //接收键盘录入，删除学生信息，也就是删除String数组中的某个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生信息：");
        String target = sc.nextLine();
        //遍历String数组，找到该元素，删除，实质是用null代替
        for (int i = 0; i < studs.length; i++) {
            if (target.equals(studs[i])) {
                System.out.println("已找到该学生，确定删除吗？(1/2)");
                int flag = sc.nextInt();
                if (flag == 1) {
                    //确定删除，找到需要删除的学生信息，置为null
                    studs[i] = null;
                    System.out.println("删除成功！");
                    return;
                } else {
                    //不删除，退出该方法
                    System.out.println("已取消删除！");
                    return;
                }
            }
        }
        //没有该学生信息
        System.out.println("无此学生！");
    }

    public static void createStudent(String[] studs) {
        System.out.println("插入之前 " + Arrays.toString(studs));
        //该方法为新增学生信息，而不是修改或者覆盖，也就是说只有当数组中有null的位置的时候才能新增学生
        //遍历数组，找到null的位置
        for (int i = 0; i < studs.length; i++) {
            if (studs[i] == null) {
                //找到第一个等于null的位置的下标i
                //使用Scanner接收一个字符串
                Scanner sc = new Scanner(System.in);
                //提示用户输入字符串，存入String数组
                System.out.println("请输入一个学生信息：");
                //将该字符串存入数组
                studs[i] = sc.nextLine();
                //输出提示语句：存入学生信息成功！
                System.out.println("存入学生信息成功！");
                System.out.println("插入之后:" + Arrays.toString(studs));
                return;
            }

        }


        //程序执行到这里，遍历数组的操作已经结束了。如果这里的代码仍然能够执行，表示数组中已经没有元素=null
        //即表示数组已经装满了
        System.out.println("String数组已满！无法存入学生信息！");

    }

    public static void printStudent(String[] studs) {

        System.out.println(Arrays.toString(studs) + "打印学生数组时");
        //该方法的实质是遍历传入的数组参数
        //方法一，直接调用API，但是这种方式会输出很多null，这种方式不合理

        //方法二，手动实现遍历数组
        //中括号在开头的位置，不要放在for里面了
        System.out.print("------------------------学生列表--------------------");
        if (studs == null || studs.length == 0) {
            //传入的参数数组为null或者这个数组的长度为0时，没有学生信息输出
            System.out.println("没有学生记录！");
            //这个时候方法结束
            return;
        }
        //代码能走到这里，说明studs数组不是null也不为空
        //用for循环打印该数组的学生信息
        System.out.println();
        for (int i = 0; i < studs.length; i++) {
            if (studs[i] == null) {
                //如果该元素是null，跳出该次循环，不打印null
                continue;
            }
            System.out.println(studs[i]);

        }

        System.out.print("------------------------学生列表结束--------------------");

    }
}

