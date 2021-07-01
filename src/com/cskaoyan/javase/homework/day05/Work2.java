package com.cskaoyan.javase.homework.day05;

/**
 * @description: 作业1
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Work2 {
    public static void main(String[] args) {
        Student s = new Student("法外狂徒-张三", 28, "男性", 18);
        s.printStu();

        Student s2 = new Student("最强男团-赵四", 38, "男性", 10);
        s2.printStu();
    }
}


class Student {
    //成员变量
    String name;
    int age;
    String gender; //isMale isFemale
    int stuId;

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Student(String name, int stuId) {
        this.name = name;
        this.stuId = stuId;
    }

    public Student(String name) {
        this.name = name;
    }

    //默认无参构造
    public Student() {
        //this(name);
        //Java是不允许在用this调用别的构造器时,使用成员变量作为参数
    }

    public Student(String name, int age, String gender, int stuId) {
        //直接使用this关键字调用三参数的有参构造
        this(name, age, gender); //对应位置写上对应的参数
        this.stuId = stuId;
    }

    public void printStu() {
        System.out.println("该学生姓名为:" + this.name + "年龄是" + this.age + "学号为" + this.stuId + "性别为" + this.gender);
    }
}