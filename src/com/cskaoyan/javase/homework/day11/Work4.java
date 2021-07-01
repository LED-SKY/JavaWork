package com.cskaoyan.javase.homework.day11;

/**
 * @description: 猫狗案例接口抽象类练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Work4 {
    public static void main(String[] args) {
        //不同的父类(接口)引用只能调用父类的成员
        //成员变量和成员方法的访问范围是根据引用的数据类型来决定的
        //这叫做编译时看左边
        //方法的运行结果要看具体的对象，这叫做运行时看右边
        //成员变量的访问无论访问范围和访问结果都看左边
    }
}

abstract class Animal{
    int age;
    String name;
    public abstract void shout();
}

interface IJump{
    void jump();
}

class Cat extends Animal implements IJump{

    @Override
    public void shout() {
        System.out.println("喵喵喵~~");
    }

    @Override
    public void jump() {
        System.out.println("小猫儿跳高高~");
    }
}

class Dog2 extends Animal implements IJump{

    @Override
    public void shout() {
        System.out.println("汪汪汪~~");
    }

    @Override
    public void jump() {
        System.out.println("小狗儿跳高高~");
    }
}
