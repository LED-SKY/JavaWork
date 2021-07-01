package com.cskaoyan.javase.homework.day01.stage1;

import java.util.Scanner;

/**
 * @description: 项目阶段一：系统菜单
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 *
 * 死循环的两种方式：
 *   while(true){
 *
 *   }
 *   for(;;){
 *
 *   }
 *
 */
public class ConsoleManage {
    public static void main(String[] args) {
        //定义循环控制变量，控制死循环结束
        boolean loopFlag = true;
        while (loopFlag) {
            System.out.println("\n-----------------王道Java学生管理系统-----------------\n");
            System.out.println("                   1.学 生 列 表");
            System.out.println("                   2.增 加 学 生");
            System.out.println("                   3.删 除 学 生");
            System.out.println("                   4.修 改 学 生");
            System.out.println("                   5.查 询 学 生");
            System.out.println("                   6.退 出 系 统\n");
            System.out.print("请选择功能(1-6)：");
            //键盘录入选择菜单
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            //switch选择菜单
            switch (input) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    //用户确定退出后询问用户 是否确认退出
                    System.out.println("确认退出吗（1/2）：");
                    int quitFlag = sc.nextInt();
                    if (quitFlag == 1) {
                        //用户确认退出，循环变量为false 死循环终止
                        loopFlag = false;
                        System.out.println("感谢使用本系统！");
                    }
                    break;
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
        }
    }

}
