package com.cskaoyan.javase.homework.day10;

/**
 * @description: 多态的练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Work2 {
    public static void main(String[] args) {
        NorthPerson np = new NorthPerson();
        SouthPerson sp = new SouthPerson();
        test(np);
        test(sp);
    }
    public static void test(Person p){
        p.eat();
    }
}

class Person {
    protected void eat(){
        System.out.println("人吃饭！");
    }
}

class SouthPerson extends Person {
    @Override
    public void eat() {
        System.out.println("南方人吃炒菜和米饭");
    }
}

class NorthPerson extends Person {
    @Override
    public void eat() {
        System.out.println("北方人吃烩菜和馒头");
    }
}
