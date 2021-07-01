package com.cskaoyan.javase.homework.day07.work2.b;

/**
 * @description: 测试类
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

//import com.cskaoyan.*;
//import com.cskaoyan.javase.homework.day07.work1.a.MyClazz;
/*
	毫无疑问，直接执行Test中的main方法会输出的是b包，思考以下问题（独立的三个问题）：
		1，不改变Test类中main方法的基础上，让main方法运行之后输出“a包”，应该怎么做？
		2，不做任何导包操作的基础上，修改main方法，让main方法运行之后同时输出“a包”和“b包”，应该怎么做？
		1个用同包下的，1个用全限定类名
		3，在Test类中添加导包语句import com.cskaoyan.*，
			不修改任何代码，执行main方法，输出的是什么？为什么？
*/
public class Test {
    public static void main(String[] args) {
        MyClazz myClazz = new MyClazz();
        myClazz.hello();
        //com.cskaoyan.javase.oop2.homework3.work1.a.MyClazz myClazz1 = new com.cskaoyan.javase.oop2.homework3.work1.a.MyClazz();
        //myClazz1.hello();
        //com.cskaoyan.javase.oop2.homework3.work1.a.MyClazz.hello();
    }
}
//'MyClazz' is already defined in this compilation unit
//class MyClazz{
//
//    public void hello() {
//        System.out.println("非public class MyClazz");
//    }
//}