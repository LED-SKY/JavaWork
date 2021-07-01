package com.cskaoyan.javase.homework.day11;

/**
 * @description: 成员内部类练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/


/**
 * 定义一条狗类
 * 狗有：年龄，姓名的属性
 * 除此之外，狗还有身体这个成员，身体有：
 * 颜色
 * 要求狗类中提供一个方法，可以显示它的整体信息
 * 并写代码进行测试
 *
 * 成员内部类普遍的用法：
 *      1，既然是内部类，理应私有化它
 *      2，私有化可以把该内部类对象作为一个私有成员变量放入列表中
 *      3，用构造器赋值（初始化）
 *
 *
 */
public class Work5 {
    public static void main(String[] args) {
        Dog dog = new Dog(10, "Tony", "白色");
        dog.showDog();
    }
}

class Dog {
    private int age;
    private String name;
    private DogBody db;

    //成员内部类
    private class DogBody {
        String color;

        public DogBody(String color) {
            this.color = color;
        }

        public DogBody() {
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    public void showDog() {
        //成员内部类创建对象提供三种方式
        //1,直接给这个方法传参颜色,创建内部类对象
        //2,传参也不传了,直接创建对象,给个颜色,比如黑色
        //3,将内部类私有化,作为外围类的一个成员变量,然后用外围类构造器赋值
        System.out.println("狗的年龄是:" + this.age + "岁\t名字是:" + this.name + "\t颜色是:" + this.db.color);
    }

    public Dog(int age, String name, String color) {
        this.age = age;
        this.name = name;
        this.db = new DogBody(color);
    }

    //为了保证正常给DogBody对象初始化,私有化无参构造或者干脆不提供
    private Dog() {
    }
}