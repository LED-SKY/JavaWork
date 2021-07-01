package com.cskaoyan.javase.homework.day08.work1;

/**
 * @description: 禁止创建学生对象
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/


/**
 * 定义一个Student类，并要求在其他类中，最多只能创建10个Student类的对象。
 *
 * 这个题目要求能够在外部控制创建对象的次数 ->
 *    要想在外部控制创建对象的次数，如果构造器是可以任意访问的，那肯定控制不了 -> 私有化构造方法
 *    私有化构造方法，外部就真的无法创建对象了，但是为了创建出10个对象，就必须提供一种方式来创建对象
 *      -> 需要提供一个方法用来创建Student对象
 *      这个方法在哪里？
 *      为了能够兼顾私有的构造方法，所以这个方法必须在Student类当中
 *      这个方法怎么写？声明怎么写？
 *      public static Student getStudentInstance(参数想写就写){
 *
 *      }
 *      于是又想到需要控制能够创建10次对象，毫无疑问需要一个计数器，每创建一次对象+1，直到创建了10次对象
 *      然后在方法中用if判断 让它不能创建对象
 *      这个计数器的变量应该写在哪里？ 这个变量必须是全体对象共享的，必须用static修饰
 *
 */
public class Student {
    //计数，这个计数器必须是类共享的，而不是每创建一个对象就新生成一个
    private static int count = 1;
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //私有化构造方法
    private Student() {
    }

    //因为构造方法已经私有化了，根据现有的知识，外部是没办法创建对象了
    //需要在内部直接给个方法创建对象
    public static Student getInstance() {
        Student student = null;
        //如果次数小于等于10次，允许继续创建对象
        if (count <= 10) {
            student = new Student();
            System.out.println("创建stu对象" + Student.count + "次");
            count++;
            return student;
        } else {
            //否则创建失败，不允许创建对象
            System.out.println("创建失败");
            //程序走到这里必然创建失败，返回null
            return student; //null
        }
    }
}