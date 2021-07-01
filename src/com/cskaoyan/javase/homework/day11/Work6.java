package com.cskaoyan.javase.homework.day11;

/**
 * @description: 静态内部类练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 4，学校里有学生，请定义一个学校类，思考怎么设计学生类
 * 学生类有age，name等属性
 * 要求在学校类中提供方法，打印学生信息
 * 并写代码测试
 *
 * 静态内部类本身可以独立做一个类，只不过借助外围类的套子保护自身
 *
 */
public class Work6 {
    public static void main(String[] args) {
        School s = new School("王道训练营");
        s.printStudent();
    }
}

class School {
    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    String name;

    private static class Student {
        int age;
        String name;

        public Student() {
        }

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public void printStudent() {
        //这里给内部类对象初始化,和狗那个案例一样,不再重复
        Student s = new Student(10, "张三");
        System.out.println("名为:" + this.name + "的学校,学生名字为:" + s.name + ",年龄为:" + s.age);
    }
}
