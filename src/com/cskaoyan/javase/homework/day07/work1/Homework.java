package com.cskaoyan.javase.homework.day07.work1;

/**
 * @description:
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 问题1: 思考注释一能否放开?会不会报错?这样书写格式好不好?怎么写可读性最好?
 * 问题2: 思考控制台输出的顺序,并用文字描述它,需要说明原因
 * 问题3: Homework building和Homework constructor会不会输出,为什么?
 */
public class Homework {
    static Student s = new Student(); //static int a = 10;
    {
        System.out.println("Homework building");
        s = null;
    }
    public static void main(String[] args) {
        System.out.println("main");
        //System.out.println(s.age); //注释一
        System.out.println(Homework.s.age);
        Person p = new Person("刘备");
        System.out.println(p.name);
    }

    public Homework() {
        System.out.println("Homework constructor");
    }
}

class Person{
    {
        name = "赵云";
        System.out.println("Person building");
    }
    String name = "曹操";
    static Student s = new Student();

    public Person() {
    }

    public Person(String name) {
        System.out.println("Person constructor");
        this.name = name;
    }
}

class Student{
    static {
        System.out.println("student static block");
    }
    int age = 10;
    {
        System.out.println("Student building");
        age = 20;
    }

    public Student(int age) {
        this.age = age;
    }

    public Student(){
        System.out.println("Student constructor");
    }
}