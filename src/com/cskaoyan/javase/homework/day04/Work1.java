package com.cskaoyan.javase.homework.day04;

/**
 * @description: 练习1
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

import java.util.Arrays;

/**
 *
 * 5，把一个数组中的某个元素全部去掉，并统计有几个该元素
 * 思考：能不能直接在原先数组中操作
 *
 * 数组的长度不可变，不可能在原先的数组上真的删除元素
 * 只能创建出一个新的数组，去掉目标元素，其余元素装到这个新数组里
 *
 * 这个新数组长度是多少？ 原先数组的长度-目标元素的个数
 *
 */

public class Work1 {
    public static void main(String[] args) {

        int target = 0; //删除0
        int[] oldArr = {1, 2, 3, 2, 2, 0, 0, 121, 3, 0, 123}; //被删除的数组
        //被删除的元素的个数
        int deleteElementNum = getDeleteElementNum(oldArr, target);
        //计算新数组的长度
        int newArrLength = oldArr.length - deleteElementNum;
        int[] newArr = new int[newArrLength];

        //调用方法
        deleteElement(oldArr, newArr, target);
        //遍历新数组
        System.out.println("删除掉某个元素后的新数组：" + Arrays.toString(newArr));
        System.out.println("删除元素的个数是：" + deleteElementNum);

    }

    //传入两个数组，删除old数组中的target元素，得到一个新数组
    public static void deleteElement(int[] oldArr, int[] newArr, int target) {
        //new数组的下标，用来赋值
        int newIndex = 0;
        //遍历old数组
        for (int i = 0; i < oldArr.length; i++) {
            //删除old数组的target元素实际上是直接把不是这个值的元素 放入新数组
            if (oldArr[i] != target) {
                newArr[newIndex] = oldArr[i];
                //赋值后数组下标+1
                newIndex++;
            }
        }
    }

    //获取一个数组中目标数据的个数
    public static int getDeleteElementNum(int[] oldArr, int target) {
        int count = 0; //计数器
        for (int i = 0; i < oldArr.length; i++) {
            if (oldArr[i] == target) {
                count++;
            }
        }
        return count;
    }
}
