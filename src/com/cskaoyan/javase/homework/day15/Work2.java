package com.cskaoyan.javase.homework.day15;

/**
 * @description: 自定义异常练习题
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 *2，分别自定义编译时异常和运行时异常，并在方法中抛出异常，main方法中调用该方法，并处理相应的异常
 *
 */
public class Work2 {
    public static void main(String[] args) {
        try {
            testThrowRuntimeException();
        } catch (MyRuntimeException e) {
            e.printStackTrace();
            System.out.println("模拟处理");
        }


        try {
            testThrowException();
        } catch (MyException e) {
            e.printStackTrace();
            System.out.println("模拟处理");
        }

    }

    public static void testThrowRuntimeException() {
        throw new MyRuntimeException("自定义的运行时异常");
    }

    public static void testThrowException() throws MyException {
        throw new MyException("自定义的编译时异常");
    }
}

//自定义编译时异常
class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }

    public MyException() {
    }
}

//自定义运行时异常
class MyRuntimeException extends RuntimeException {
    public MyRuntimeException() {
    }

    public MyRuntimeException(String message) {
        super(message);
    }
}
