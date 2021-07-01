package com.cskaoyan.javase.homework.day06;

/**
 * @description: 第四题 数组工具类
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Work2 {
    public static void main(String[] args) {
        //无需创建对象 只能通过类名点方式访问方法

    }
}

//ArrayUtils
class ArrayTool {

    //数组的遍历
    //判断数组是否长度为0 长度为0直接输出[]
    public static void traverse6(int[] arr) {
        if (arr == null) {
            //友好提示
            System.out.println("您输入的数据有误,请输入一个正确的数组!");
            return; //立刻结束当前方法
        }
        //如果代码走到了这里,代表传入的数组一定不是null
        if (arr.length == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            //最后一个元素不应该加逗号
            //需要用if判断这个元素是否是最后一个元素
            if (i == arr.length - 1) {
                //这个i是数组最大的下标 代表最后一个元素
                System.out.println(arr[i] + "]");
            } else {
                //该元素不是最后一个元素 需要加逗号
                System.out.print(arr[i] + ", ");
            }
        }
    }


    //求数组的最大值，最小值
    //求数组中元素的最大值
    public static int getArrayMaxValue(int[] arr) {
        //1，假设第一个元素是最大值
        int max = arr[0];
        //2，遍历这个数组，逐个比较
        //第一个元素已经是最大值了，从第二个开始比
        for (int i = 1; i < arr.length; i++) {
            //如果该元素比max大，它就成为新的max
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    //求数组中元素的最小值
    public static int getArrayMinValue(int[] arr) {
        //1，假设第一个元素是最小值
        int min = arr[0];
        //2，遍历这个数组，逐个比较
        //第一个元素已经是最小值了，从第二个开始比
        for (int i = 1; i < arr.length; i++) {
            //如果该元素比min小，它就成为新的min
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    //数组的逆置
    public static void reverse2(int[] arr) {
        for (int start = 0, end = arr.length - 1; start <= end; start++, end--) {
            int a , b ,c=10;
            //int a1 = 10,double a = 10;
            //交换
            int temp;
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }


    //该方法输出的是查找到的元素，第一次出现的下标
    public static int retrieveFirst(int[] arr, int targetValue) {
        //定义一个目标下标
        //返回数组下标的时候，初始值普遍设置成-1
        int targetIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            //逐一比对
            if (arr[i] == targetValue) {
                //只要找到一个该元素，立刻结束方法或者立刻结束循环
                //targetIndex = i;
                //break; //立刻结束循环
                return i ;
            }
        }
        return targetIndex;
    }

    //该方法输出的是查找到的元素，最后一次出现的下标
    //两个参数：被查询的数组，查询的值
    public static int retrieveLast(int[] arr, int targetValue) {
        //定义一个目标下标
        //返回数组下标的时候，初始值普遍设置成-1
        int targetIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            //逐一比对
            if (arr[i] == targetValue) {
                targetIndex = i;
            }
        }
        return targetIndex;
    }


}
