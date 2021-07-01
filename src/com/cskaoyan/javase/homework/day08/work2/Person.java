package com.cskaoyan.javase.homework.day08.work2;

/**
 * @description: 人 类
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 *
 * 私有化成员变量,然后提供get/set方法
 * 还需要提供一个方法用于访问成员变量的取值
 *
 */
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print(){
        System.out.println("名字为"+ this.name + "   年龄为"+ this.age);
    }
}
