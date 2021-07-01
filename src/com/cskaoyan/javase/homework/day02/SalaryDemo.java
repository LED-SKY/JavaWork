package com.cskaoyan.javase.homework.day02;

import java.util.Scanner;

/**
 * @description: 计算税收的方法
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class SalaryDemo {
    public static void main(String[] args) {
        System.out.print("请输入工资：");
        Scanner sc = new Scanner(System.in);
        double salary = sc.nextDouble();//工资

        if (salary <= 2000) {
            System.out.println("不用缴税，到手工资为：" + getSalaryLeft(salary));
        } else {
            System.out.println("缴纳的个人所得税为：" + getTax(salary));
            System.out.println("实际到手工资为：" + getSalaryLeft(salary));
        }
    }

    public static double getSalaryLeft(double salary) {

        double salaryLeft;//到手工资
        //应缴纳税额
        double tax = getTax(salary);
        salaryLeft = salary - tax;
        return salaryLeft;

    }

    //获取要缴纳的税额
    public static double getTax(double salary) {
        double tax = 0;//应纳税额
        double taxable = 0;//应纳税所得额
        if (salary <= 2000) {
            tax = 0;
            return tax;
        } else {
            taxable = salary - 2000;
            double taxRate = 0;//税率
            double deduction = 0;//速算扣除数
            if (taxable < 500 | taxable == 500) {
                taxRate = 0.05;
                deduction = 0;
            } else if (taxable > 500 && (taxable < 2000 | taxable == 2000)) {
                taxRate = 0.1;
                deduction = 25;
            } else if (taxable > 2000 && (taxable < 5000 | taxable == 5000)) {
                taxRate = 0.15;
                deduction = 125;
            } else if (taxable > 5000 && (taxable < 20000 | taxable == 20000)) {
                taxRate = 0.2;
                deduction = 375;
            } else if (taxable > 20000 && (taxable < 40000 | taxable == 40000)) {
                taxRate = 0.25;
                deduction = 1375;
            } else if (taxable > 40000 && (taxable < 60000 | taxable == 60000)) {
                taxRate = 0.3;
                deduction = 3375;
            } else if (taxable > 60000 && (taxable < 80000 | taxable == 80000)) {
                taxRate = 0.35;
                deduction = 6375;
            } else if (taxable > 80000 && (taxable < 100000 | taxable == 100000)) {
                taxRate = 0.4;
                deduction = 10375;
            } else if (taxable > 100000) {
                taxRate = 0.45;
                deduction = 15375;
            }
            tax = taxable * taxRate - deduction;
            return tax;
        }
    }
}

