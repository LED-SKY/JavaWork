package com.cskaoyan.javase.homework.day12;

/**
 * @description: 作业3
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * Cat：
 * 成员变量：age，name，Dog
 * Dog：
 * 成员变量：age
 * 手写Cat类的toString()和equals()方法
 *
 */
public class Work3 {
    public static void main(String[] args) {
    }
}

class Cat {
    int age;
    String name;
    Dog dog;

    public Cat() {
    }

    public Cat(int age, String name, Dog dog) {
        this.age = age;
        this.name = name;
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Cat{" + "age=" + this.age + ", name='" + this.name + '\'' + ", dog=" + this.dog + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cat cat = (Cat) o;

        if (age != cat.age) {
            return false;
        }
        if (name != null ? !name.equals(cat.name) : cat.name != null) {
            return false;
        }
        return dog != null ? dog.equals(cat.dog) : cat.dog == null;
    }

}

class Dog {
    int age;

    public Dog() {
    }

    public Dog(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" + "age=" + this.age + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return age == dog.age;
    }

}
