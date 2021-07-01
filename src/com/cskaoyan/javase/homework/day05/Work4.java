package com.cskaoyan.javase.homework.day05;

/**
 * @description: 作业4
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 成员变量,成员方法,合起来称之为类的成员,都是属于对象的
 * 必须要有一个对象才能去调用
 * 在成员方法中,是可以使用本对象的成员变量的
 *
 *
 */
public class Work4 {
    public static void main(String[] args) {
        //创建对象
        //Cuboid c = new Cuboid();
        //c.height = 3;
        //c.length = 4;
        //c.width = 5;
        Cuboid c = new Cuboid(3, 4, 5);
        double area = c.getArea();
        double volume = c.getVolume();
        System.out.println("该长方体的表面积是" + area);
        System.out.println("该长方体的体积是" + volume);

    }


}

class Cuboid {
    double length;//长
    double width;//宽
    double height;//高

    public Cuboid() {
    }

    public Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    //求体积 长*宽*高
    public double getVolume() {
        return length * width * height;
    }

    //求表面积 (长*宽 + 宽*高 + 长*高)
    public double getArea() {
        return 2 * (length * width + length * height + width * height);
    }

}