package com.cskaoyan.javase.homework.day14;

/**
 * @description: 字符串练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Work2 {
    public static void main(String[] args) {
       String s = "woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
        System.out.println(getCountSubString(s, "java"));
    }

    public static int getCountSubString(String bigStr, String smallStr) {
        int fromIndex = 0; //查询大串的起始下标
        int count = 0; //小串出现的次数
        //具体查询的方式有很多种
        //这里推荐int indexOf(String str,int fromIndex) 这个方法
        //该方法可以从大字符串中查询小字符串 并返回下标 如果没找到返回-1
        //然后需要注意的是该方法查找的结果是子串的第一个字符的下标
        //所以下一次查找要给fromIndex+1
        while ( (fromIndex = bigStr.indexOf(smallStr, fromIndex)) != -1) {
            //找到一次小串
            count++;
            fromIndex++;
        }
        return count;
    }
}
