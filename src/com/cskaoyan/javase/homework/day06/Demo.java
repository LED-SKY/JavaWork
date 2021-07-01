package com.cskaoyan.javase.homework.day06;

/**
 * @description: debug查看成员变量的赋值顺序
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Demo {
    public static void main(String[] args) {
        //注意不要同时放开两个new语句，避免互相影响
        //debug语句一，可以进入查看age的赋值过程
        //Person p = new Person(18);
        //debug语句二，进入查看nationality赋值过程
        Person p2 = new Person("中国");
    }
}

class Person {
    int age = 10;
    static String nationality = "美国";

    public Person(int age) {
        this.age = age;
    }


    public Person() {
    }

    public Person(String nationality) {
        Person.nationality = nationality;
    }
}
