package com.cskaoyan.javase.homework.day09;

/**
 * @description: 继承中代码块的练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 不难发现，静态代码块和构造代码块，构造器的执行顺序总是：
 *      1，静态代码块（因为类加载）
 *      2，构造代码块
 *      3，构造器（永远最后执行）
 *
 * 引入继承概念后，记住先父后子
 *
 * 结合上述两个特点，很容易得出这道题的结论
 *
 *
 */
public class Work1 {
    public static void main(String[] args) {
        Sub sub = new Sub();
    }
}

class Base{
    static {
        System.out.println("base 静态代码块");
    }
    {
        System.out.println("base 构造代码块");
    }
    public Base(){
        //隐含super()
        System.out.println("base无参构造");
    }
}

class Sub extends Base{
    static {
        System.out.println("sub 静态代码块");
    }
    {
        System.out.println("sub 构造代码块");
    }
    public Sub(){
        //隐含super() 去调用父类的无参构造方法
        System.out.println("sub 无参构造");
    }
}