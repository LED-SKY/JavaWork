package com.cskaoyan.javase.homework.day04;

/**
 * @description: 问题5 递归求十进制转换成二进制,正整数 N>0
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Work5 {
    public static void main(String[] args) {
        decimalToBinary(1);
    }

    /**
     * 分析：既然是用递归的思想，那么首先要考虑递归的出口，对于一个十进制数来说，把它转换成二进制，是用除2取余，然后把余数倒过来读数，就是该数的二进制表示
     * 这个过程中，无论十进制数多大，最终除的商一定是0，这就是递归的出口
     * 那么：
     * 只要商不是0，就继续除以2，直到商为0，这就是递归体
     * 最后打印这个余数即可
     *
     * 打印余数一定要记住是倒读的，所以这里需要借助栈的一个先进后出的特性
     * 所以，递归体，一定要在打印余数的上面
     *
     */
    public static void decimalToBinary(int n) {
        //如果商是0了，表示递归需要结束了
        if (n == 0) {
            return;
        }else {
            //只要商不是0，就继续递归
            decimalToBinary(n / 2);
        }
        System.out.print(n % 2);
    }
}
