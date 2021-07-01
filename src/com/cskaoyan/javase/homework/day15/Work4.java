package com.cskaoyan.javase.homework.day15;

/**
 * @description: 带过滤器的文件获取listFiles方法
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

import java.io.File;

/**
 * 仅针对这三个条件提供规则方法，具体实现自己去做
 * 条件一：仅留下文件夹名包括a的文件夹
 * 条件二：仅留下.txt结尾的文本文件
 * 条件三：仅留下以a开头的文件
 *
 */
public class Work4 {
    public static void main(String[] args) {
        //具体自己实现，可以选择匿名内部类，lambda表达式都行
    }

    public static boolean condition1(File file) {
        return file.isDirectory() && file.getName().contains("a");
    }
    public static boolean condition2(File file) {
        return file.isFile() && file.getName().endsWith(".txt");
    }
    public static boolean condition3(File file) {
        return file.isFile() && file.getName().startsWith("a");
    }
}
