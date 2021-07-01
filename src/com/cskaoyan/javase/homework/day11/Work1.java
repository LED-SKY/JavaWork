package com.cskaoyan.javase.homework.day11;

public class Work1 {

}

abstract class Graphics {
    private int area;
    private int perimeter;

    //方式一: 提供必要的方法访问属性getter/setter方法
    /*public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(int perimeter) {
        this.perimeter = perimeter;
    }*/

    //方式二: 访问的方法,作为子类默认实现
    public void print(){
        System.out.println(area + perimeter);
    }

    abstract void draw();
}
