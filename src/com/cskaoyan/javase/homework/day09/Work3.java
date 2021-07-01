package com.cskaoyan.javase.homework.day09;

/**
 * @description:
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 对象名点访问成员变量,它的访问范围是引用的数据类型来决定,只能访问引用的类型里有的变量或者其父类的变量
 * 并且成员变量的访问结果也是引用的数据类型来决定的
 *
 * 对象名点访问成员方法,它的访问范围是引用数据类型来决定的,仍然是从引用的类型中找该方法,找不到去父类中找,直到Object找不到就报错
 *
 * 方法的执行结果体现成方法的覆盖而不是隐藏,也就是说方法的执行结果是由它的具体的对象的类型来决定的
 * 如果有同名的方法,执行的结果跟对象的类型相关
 *
 *
 *
 */
public class Work3 {
    public static void main(String[] args) {

        //不同方式创建对象,回答问题
        Father fs = new Son();
        //System.out.println(fs.var); //30
        fs.test(); //sonTest

        Son s = new Son();
        //System.out.println(s.var); //300
        s.test(); //sonTest

        Father f = new Father();
        //System.out.println(f.var); //30
        f.test(); //fatherTest

        Grandfather gfs = new Son();
        //System.out.println(gf.var); //3
        gfs.test(); //sonTest

        Grandfather gf = new Grandfather();
        gf.test(); //grandfather test


    }
}

class Grandfather {
    int gA = 1;
    int gB = 2;
    int var = 3;

    public void testGrand() {
        System.out.println("testGrand");
    }

    public void test() {
        System.out.println("Grandfather test");
    }

    public Grandfather(int gA, int gB, int var) {
        this.gA = gA;
        this.gB = gB;
        this.var = var;
    }

    public Grandfather() {
    }
}

class Father extends Grandfather {
    int fA = 10;
    int fB = 20;
    int var = 30;

    public void testFather() {
        System.out.println("testFather");
    }

    public void test() {
        System.out.println("Father test");
    }

    public Father(int fA, int fB, int var) {
        this.fA = fA;
        this.fB = fB;
        this.var = var;
    }

    public Father() {
    }
}

class Son extends Father {
    int sA = 100;
    int sB = 200;
    int var = 300;

    public void testSon() {
        System.out.println("testSon");
    }

    public void test() {
        System.out.println("Son test");
    }

    public Son() {
    }

    public Son(int sA, int sB, int var) {
        this.sA = sA;
        this.sB = sB;
        this.var = var;
    }

    public Son(int fA, int fB, int var, int sA, int sB, int var1) {
        super(fA, fB, var);
        this.sA = sA;
        this.sB = sB;
        this.var = var1;
    }
}
