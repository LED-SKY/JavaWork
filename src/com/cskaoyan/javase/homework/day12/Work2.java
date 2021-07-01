package com.cskaoyan.javase.homework.day12;

/**
 * @description: lambda表达式
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Work2 {
    public static void main(String[] args) {
        INoReturnNoParam ir1 = () -> {
            System.out.println("无返回值无参数的功能接口");
        };
        ir1.test();

        ((INoReturnOneParam) a -> {
            System.out.println("无返回值有一个参数的功能接口,其参数是:" + a);
        }).test(10);

        INoReturnTwoParam ir2 = (a, b) -> System.out.println("无返回值两个参数的功能接口,其两个参数分别是:" + a + "," + b);

        ir2.test(10, 20);
        IHasReturnNoParam ir3 = () -> {
            int a = 10;
            int b = 20;
            return a + b;
        };
        System.out.println("有返回值无参数的功能接口,其返回值是:" + ir3.test());

        IHasReturnOneParam ir4 = a -> ++a;
        System.out.println("有返回值一个参数的功能接口,其返回值是" + ir4.test(10));

        IHasReturnTwoParam ir5 = (a, b) -> a + b;
        System.out.println("有返回值两个参数的功能接口,其返回值是:" + ir5.test(1,2));

    }
}

//无返回值无参数的功能接口
@FunctionalInterface
interface INoReturnNoParam {
    void test();
}

//无返回值有一个参数的功能接口
@FunctionalInterface
interface INoReturnOneParam {
    void test(int a);
}

//无返回值两个参数的功能接口
@FunctionalInterface
interface INoReturnTwoParam {
    void test(int a, int b);
}

//有返回值无参数的功能接口
@FunctionalInterface
interface IHasReturnNoParam {
    int test();
}

//有返回值一个参数的功能接口
@FunctionalInterface
interface IHasReturnOneParam {
    int test(int a);
}

//有返回值两个参数的功能接口
@FunctionalInterface
interface IHasReturnTwoParam {
    int test(int a, int b);
}
