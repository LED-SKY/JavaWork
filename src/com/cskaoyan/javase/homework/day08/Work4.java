package com.cskaoyan.javase.homework.day08;

/**
 * @description: 第六题
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 这个案例中，为了复用成员，需要新建一个父类Animal
 *
 * 手写猫狗案例，并进行测试，要求使用继承
 *  猫：姓名，年龄，颜色，可以叫，可以抓老鼠
 * 狗：姓名，年龄，性别，可以叫，可以看门
 *
 * 机器人类显然和动物没有is-a关系,不应该为了复用成员,强行使用继承
 *
 *
 */
public class Work4 {
    public static void main(String[] args) {
        Cat c = new Cat();
        Dog d = new Dog();

        //c和d都可以访问父类Animal当中的成员,也可以访问自己定义的独特成员
        c.catchMouse();
        System.out.println(c.getName());

        d.watchDoor();
        System.out.println(d.getName());
    }
}

class Animal {
    private String name;
    private int age;

    public void shout(){
        System.out.println("我会叫！");
    }

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
}

class Cat extends Animal {
    private String color;
    public void catchMouse(){
        System.out.println("我会抓老鼠！");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class Dog extends Animal {
    private String gender;
    public void watchDoor(){
        System.out.println("我会看门！");
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}


