package com.cskaoyan.javase.homework.day12;

/**
 * @description: 计算器
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 常规的做法是：写好一个接口，接口里面全是加减乘除的抽象方法
 * 然后用匿名内部类实现接口，逐一调用方法
 * 常规方法很容易想到，但不是最简洁的。
 * 我们考虑Java的多态性，把接口（的实现子类对象）传入方法，调用接口中唯一的抽象方法
 *
 */
public class Work1_1 {
    public static void main(String[] args) {

        //加的方法
        ComputeTool.calc(new Compute() {
            @Override
            public double compute(double a, double b) {
                return a + b;
            }
        }, 10, 20);

        //减
        ComputeTool.calc(new Compute() {
            @Override
            public double compute(double a, double b) {
                return a - b;
            }
        }, 10, 9);

        //乘以
        ComputeTool.calc((a, b) -> (a * b), 10, 10);

        /*Compute c = (a, b) -> a + b;
        System.out.println(c.compute(10, 20));*/

    }

}

//工具类，用来做计算计算
class ComputeTool {
    private ComputeTool() {
    }

    public static void calc(Compute com, double a, double b) {
        System.out.println("计算的结果是：" + (com.compute(a, b)));
    }
}

//功能接口,可以用lambda表达式
@FunctionalInterface
interface Compute {
    double compute(double a, double b);
}


