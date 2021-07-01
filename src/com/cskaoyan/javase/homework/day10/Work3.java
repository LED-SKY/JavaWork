package com.cskaoyan.javase.homework.day10;

/**
 * @description: 抽象类的练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 定义抽象类A，抽象类B继承A，普通类C继承B
 * A类中，定义成员变量a赋值为10，抽象showA方法。
 * B类中，定义成员变量b赋值为20，抽象showB方法。
 * C类中，定义成员变量c赋值为30，重写showA方法打印a，重写showB方法打印b，定义showC方法，打印c。
 * 测试类中，创建C对象，调用showA方法，showB方法，showC方法。
 *
 */
public class Work3 {
    public static void main(String[] args) {
        C c = new C();
        c.showA();
        c.showB();
        c.showC();
    }
}

abstract class A{
    int a = 10;
    public abstract void showA();
}

abstract class B extends A{
    int b = 20;
    public abstract void showB();
}

class C extends B{
    int c = 30;
    @Override
    public void showA() {
        System.out.println(a);
    }

    @Override
    public void showB() {
        System.out.println(b);
    }

    public void showC(){
        System.out.println(c);
    }
}
