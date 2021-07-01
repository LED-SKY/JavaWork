package com.cskaoyan.javase.homework.day11;

/**
 * @description: 内部类基本使用的练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 理清楚每种内部类的使用特点
 * 内部类本身来讲并不会十分困难
 *
 */

public class Work2 {
    public static void main(String[] args) {
        //创建并初始化Bean1类对象bean1
        //外围类的静态方法中,创建成员内部类的对象
        Bean1 bean1 = new Work2().new Bean1();
        bean1.i++;

        // 创建并初始化Bean2类对象bean2
        //外围类的静态方法中,创建静态内部类对象
        Bean2 bean2 = new Bean2();
        bean2.j++;

        //创建并初始化Bean3类对象bean3
        //在外部类当中创建成员内部类对象
        Bean.Bean3 bean3 = new Bean().new Bean3();
        bean3.k++;
    }

    class Bean1 {
        public int i = 0;
    }

    static class Bean2 {
        public int j = 0;
    }
}

class Bean {
    class Bean3 {
        public int k = 0;
    }
}
