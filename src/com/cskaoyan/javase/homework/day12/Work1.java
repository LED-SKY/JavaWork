package com.cskaoyan.javase.homework.day12;

/**
 * @description: 匿名内部类的练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Work1 {
    public static void main(String[] args) {

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
        class Inner implements ICalc {
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

        System.out.println("----------匿名内部类的方式----------");
        ICalc i = new ICalc() {
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
        };
        System.out.println(i.add(1, 2));
        System.out.println(i.subtract(2, 1));
        System.out.println(i.multiply(2, 2));
        System.out.println(i.divide(6, 3));


        System.out.println("----------匿名内部类的方式----------");

    }
}

interface ICalc {
    int add(int a, int b);

    int subtract(int a, int b);

    int multiply(int a, int b);

    int divide(int a, int b);
}

