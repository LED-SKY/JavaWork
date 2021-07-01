package com.cskaoyan.javase.homework.day08.work2;

/**
 * @description: 测试
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Test {
    public static void main(String[] args) {
        Person p = ScannerTool.getPersonInstanceByScanner();
        //System.out.println(p.getAge());
        //System.out.println(p.getName());
        p.print();


        System.out.println("-----------------------");
        Person[] personArrByScanner = ScannerTool.getPersonArrByScanner(5);
        for (Person person : personArrByScanner) {
            person.print();
        }
    }
}
