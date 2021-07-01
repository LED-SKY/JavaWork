package com.cskaoyan.javase.homework.day08;

/**
 * @description: getter/setter方法练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Work3 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 3);
        System.out.println(r.getArea());
        System.out.println(r.getCircumference());

        Square s = new Square(5);
        System.out.println(s.getArea());
        System.out.println(s.getCircumference());
    }
}

//长方形类
class Rectangle {
    private double length; //长
    private double width; //宽

    //构造方法
    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    //get、set方法
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    //获取面积
    public double getArea() {
        return this.length * this.width;
    }

    //获取周长
    public double getCircumference() {
        return 2 * (this.length + this.width);
    }
}

//正方形类
class Square {
    private double length;

    public Square() {
    }

    public Square(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    //获取面积
    public double getArea() {
        return this.length * this.length;
    }

    //获取周长
    public double getCircumference() {
        return 4 * this.length;
    }
}