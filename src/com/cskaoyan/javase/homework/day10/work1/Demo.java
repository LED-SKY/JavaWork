package com.cskaoyan.javase.homework.day10.work1;

/**
 * @description: final练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 自定义一个类，类中定义三个成员变量a，b，c，用final修饰这三个成员变量
 * 再定义两个静态成员变量staticA和staticB，也用final修饰这两个静态成员变量
 * 然后：
 * 	1，请用三种不同的方式，分别为a，b，c赋值
 * 	2，请用两种不同的方式，分别为staticA和staticB赋值
 *
 *
 * 	复习一下成员变量的赋值：
 * 	    （掐头去尾）
 * 	    头：默认初始化，有默认值
 * 	    尾：构造器
 * 	    中间：显式赋值和构造代码块，顺序是代码的书写顺序
 *
 * 	    最后在加上父子类，先父后子
 *
 */
public class Demo {
}


class A {
    final int a = 10;
    final int b;

    {
        b = 20;
    }

    final int c;

    public A(int c) {
        this.c = c;
    }

    static final int staticA = 100;
    static final int staticB;

    static {
        staticB = 200;
    }
}
