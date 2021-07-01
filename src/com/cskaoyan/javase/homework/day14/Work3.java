package com.cskaoyan.javase.homework.day14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @description: Date日期类的练习
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class Work3 {
    public static void main(String[] args) throws ParseException {
        int days = TimeUtils.calcBornDays();
        if (days == -1){
            System.out.println("显然你无法在未来出生");
        }else {
            System.out.println("你已出生 "+ days + " 天！");
        }
    }

}

class TimeUtils{
    private static final Scanner sc = new Scanner(System.in);
    private TimeUtils(){}
    public static int calcBornDays() throws ParseException {
        System.out.println("请输入您的出生日期，格式yyyy/MM/dd: ");
        String birthday = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date birthTime = sdf.parse(birthday);
        //获取当前的日期的毫秒数
        Date currentTime = new Date();
        long currentSeconds = currentTime.getTime();
        long birthSeconds = birthTime.getTime();
        //计算毫秒值之差
        long seconds = currentSeconds - birthSeconds;
        if (seconds < 0 ){
            return -1;
        }else {
            return ((int) (seconds / 1000 / 3600 / 24));
        }
    }

}
