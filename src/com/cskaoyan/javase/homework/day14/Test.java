package com.cskaoyan.javase.homework.day14;

/**
 * @description: 测试包装类的不可变性
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 包装类的底层实际上也是通过一个final修饰的变量来存放数据
 *      所以每一个包装类对象也具有不可变性
 * 一旦修改其取值，就得到了另一个新的对象
 *
 */
public class Test {
    public static void main(String[] args) {
        Integer i = new Integer("123");
        System.out.println(i); //123
        doubleIntegerValue(i);
        System.out.println(i); //123
    }

    public static void doubleIntegerValue(Integer i) {
        //方法内改变其取值，虽然是改变了成员变量的取值
        //但实际上由于对象不可变,需要创建一个新对象,对原先的实参对象是没有影响的
        //这一点String,包装类都是如此
        i *= 2;
    }
}
