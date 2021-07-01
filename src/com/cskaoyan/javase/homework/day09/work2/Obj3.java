package com.cskaoyan.javase.homework.day09.work2;

/**
 * @description: 继承中赋值顺序的练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 和Work1基本一致
 *  Obj2 ob2 = new Obj2(); 实际和 int a = 10; 无明显区别
 *
 */
public class Obj3 extends Obj1 {
    static {
        System.out.println("Obj3类加载");
    }
    Obj2 ob2 = new Obj2();
    public Obj3(){
        //隐含super() 表示调用父类的无参构造
        System.out.println("obj3");
    }
    public static void main(String[] args) {
        System.out.println("main开始执行");
        Obj3 obj3 = new Obj3();
    }
}

class Obj1 {
    static {
        System.out.println("Obj1类加载");
    }
    Obj2 ob2 = new Obj2(); //int a = 10;
    public Obj1() {
        System.out.println("Obj1");
    }
}

class Obj2 {
    static {
        System.out.println("Obj2类加载");
    }
    public Obj2() {
        System.out.println("obj2");
    }
}