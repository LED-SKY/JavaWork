package com.cskaoyan.javase.homework.day15;

import java.io.File;

/**
 * @description: File练习题-递归删除文件夹
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Work3 {
    public static void main(String[] args) {
        File file = new File("E:\\1");
        System.out.println("是否已经删完?" + deleteDirectory(file));
    }

    public static boolean deleteDirectory(File target) {
        //获取目标目录下的所有文件的file对象
        File[] files = target.listFiles();

        if (files == null || files.length == 0) {
            //如果传入的target对象是一个文件或者是一个空目录，直接删除
            return target.delete();
        }
        //如果代码执行到这里，说明传入的target对象是一个不能空的目录
        //需要先删除目录下的所有文件,才能删除该目录
        //遍历这个File对象数组 遍历中无需下标 所以可以用增强for
        for (File file : files) {
            if (file.isDirectory()) {
                //该file对象是一个目录,需要递归删除
                deleteDirectory(file);
            } else {
                //该file对象是一个文件,直接删除
                file.delete();
            }
        }

        //代码执行到这里,遍历结束了,target目录内容已经删完了,只需要删除target目录即可
        //target目录此时已经是空目录了
        return target.delete();
    }
}
