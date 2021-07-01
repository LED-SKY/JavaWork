package com.cskaoyan.javase.homework.day11;

/**
 * @description: 局部内部类在接口中的应用
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Work3 {
    public static void main(String[] args) {
        System.out.println("----------创建实现类对象的方式-------------");
        ICalcImpl iCalc = new ICalcImpl();
        System.out.println(iCalc.add(1, 2));
        System.out.println(iCalc.subtract(2, 1));
        System.out.println(iCalc.multiply(2, 2));
        System.out.println(iCalc.divide(6, 3));
        System.out.println("----------创建实现类对象的方式-------------");
        /**
         * 局部内部类的优点:
         *  绝对的封装,对外界绝对隐藏,局部内部类仅有方法能够访问,外部都是不能访问
         *  局部内部类的使用可以稍微简化一些代码书写
         * 局部内部类的缺点:
         *  外界无法使用该对象,不能访问该内部类
         *
         * 什么时候使用局部内部类:
         *  该对象就在某个方法内部使用,其余方法,其余地方不使用,那么我就用局部内部类,方便快捷省事
         *
         * 不应该用的场景是: 方法外部也要使用对象,或者多处需要使用
         *
         */
        System.out.println("----------局部内部类的方式-------------");
        class Inner implements ICalc{
            @Override
            public int add(int a, int b) {
                return a + b;
            }
            @Override
            public int subtract(int a, int b) {
                return a - b;
            }
            @Override
            public int multiply(int a, int b) {
                return a * b;
            }
            @Override
            public int divide(int a, int b) {
                return a / b;
            }
        }
        Inner inner = new Inner();
        System.out.println(inner.add(1, 2));
        System.out.println(inner.subtract(2, 1));
        System.out.println(inner.multiply(2, 2));
        System.out.println(inner.divide(6, 3));
        System.out.println("----------局部内部类的方式-------------");

    }
}

interface ICalc {
    int add(int a, int b);

    int subtract(int a, int b);

    int multiply(int a, int b);

    int divide(int a, int b);
}

//写实现类，然后创建对象
class ICalcImpl implements ICalc {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public int divide(int a, int b) {
        return a / b;
    }
}
