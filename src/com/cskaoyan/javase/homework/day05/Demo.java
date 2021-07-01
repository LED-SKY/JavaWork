package com.cskaoyan.javase.homework.day05;

/**
 * @description: Debug模式操作练习题
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 创建对象过程中,成员变量的赋值:
 *    1,第一步永远是先默认初始化,成员变量具有默认值
 *    2,去找到new对象使用的构造方法
 *    3,考虑该构造方法的第一行有没有this去调用别的构造方法
 *          a,如果没有,也不会立刻执行构造方法,而是先去执行成员变量的显式赋值(如果有的话)
 *          b,如果有this构造器,立刻跳到this构造器,然后也不会立刻执行this构造器,
 *              而是先去执行成员变量的显式赋值(如果有的话)
 *              成员变量的显式赋值执行结束后,再执行this构造方法
 *              this构造方法执行结束后,不会再执行显式赋值,而是立刻回去执行new对象调用的那个构造方法
 *
 *    注意: 成员变量的显式赋值,是按照代码书写的从上到下的顺序,全部执行
 *
 */
public class Demo {
    public static void main(String[] args) {
        Person s = new Person(18, "李明");
        System.out.println(s.age); //18
        System.out.println(s.name); //"李明"
        System.out.println(s.a); //100.0
        //p : parameter 参数
        //f : field 成员变量
    }
}

class Person {
    int age = 10;
    String name = "张三";
    double a = 100;

    public Person(int age) {
        System.out.println("Person age");
        this.age = age;
    }

    public Person() {
    }

    public Person(int age, String name) {
        this(age);
        System.out.println("Person age,name");
        this.name = name;
    }
}