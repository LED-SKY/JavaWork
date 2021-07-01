package Stage.utils;

import Stage.entity.CRUD;
import Stage.entity.Student;


import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**
 * @program: statge1
 * @description: 键盘输入工具类
 * @author: 邓造坚
 * @create: 2021-06-16 13:53
 **/
public class ScannerUtils {
    public static final Scanner sc = new Scanner(System.in);
    public static boolean continueToInput = true;

    private ScannerUtils() {
    }

    public static Student inputStudent(CRUD crud) {
        int stuId = 0;
        String name = "";
        String sex = "";
        int age = 0;
        String grade = "";
        String phoneNum = "";
        int count = 1;
        while (continueToInput) {

            switch (count) {

                case 1:
                    System.out.print("请输入学号：");
                    stuId = crud.judgeStuId();

                    //检查学号是否大于0
                    if (!checkStudentNumberScope(stuId)) {
                        count = 1;
                    } else {
                        ++count;
                    }

                    break;
                case 2:
                    System.out.print("请输入要录入学生的姓名：");
                    name = sc.nextLine();
                    if (!checkStudentName(name)) {
                        count = 2;
                    } else {
                        ++count;
                    }
                    break;
                case 3:
                    System.out.print("请输入要录入学生的性别：");
                    sex = sc.nextLine();
                    if (!checkStudentSex(sex)) {
                        count = 3;
                    } else {
                        ++count;
                    }
                    break;
                case 4:
                    System.out.print("请输入要录入学生的年龄：");
                    String tempStringAge = sc.nextLine();
                    age = Integer.parseInt(tempStringAge);
                    if (!checkStudentAge(age)) {
                        count = 4;
                    } else {
                        ++count;
                    }
                    break;
                case 5:
                    System.out.print("请输入要录入学生的班级：");
                    grade = sc.nextLine();
                    if (!checkStudentGrade(grade)) {
                        count = 5;
                    } else {
                        ++count;
                    }
                    break;
                case 6:
                    System.out.print("请输入要录入学生的电话号码：");
                    phoneNum = sc.nextLine();
                    if (!checkStudentPhone(phoneNum)) {
                        count = 6;
                    } else {
                        continueToInput = false;
                    }
                    break;
            }
        }
        continueToInput = true;
        return new Student(stuId, name, sex, age, grade, phoneNum);
    }


    //获取用户输入的菜单选项
    public static int getMenuNumber() {
        int chooseIn;
        while (true) {
            try {
                //获取输入的字符串
                String s = sc.nextLine();
                //将字符串强制转换为Int类型
                chooseIn = Integer.parseInt(s);
                break;
            } catch (NumberFormatException e) {
                System.out.println("你输入的不是整数");
                System.out.println("请输入1/2/3/4/5/6：");
            }

        }
        return chooseIn;

    }


    //    获取用户是否退出系统
    public static int outSystem() {
        int exitIn;
        
        try {
            exitIn = Integer.parseInt(sc.nextLine());
            return exitIn;
        } catch (NumberFormatException e) {
            System.out.println("你输入的不是数字");
        }
        return 0;
    }

    //  获取学号
    public static int getStuId() {
        int stuId;
        try {
            stuId = Integer.parseInt(sc.nextLine());
            return stuId;
        } catch (NumberFormatException e) {
            System.out.println("你输入的不是数字");
        }
        return -1;
    }

    //控制学号不能小于0
    private static boolean checkStudentNumberScope(int num) {

        if (num < 0) {
            System.out.println("学号不能小于0");
            return false;
        } else {
            System.out.println("学号合法");
            return true;
        }
    }

    //控制姓名的字符串长度必须大于1并且小于等于5
    private static boolean checkStudentName(String name) {
        if (name.length() < 1 || name.length() > 5) {
            System.out.println("姓名的字符串长度必须大于1并且小于等于5");
            return false;
        } else {
            System.out.println("输入的姓名合法");
            return true;
        }
    }

    //性别只允许从“男”，“女”中选择
    private static boolean checkStudentSex(String sex) {
        if ("男".equals(sex) || "女".equals(sex)) {
            System.out.println("输入的性别合法");
            return true;
        } else {
            System.out.println("性别只允许从“男”，“女”中选择");
            return false;
        }
    }

    //班级必须以“班”结束
    private static boolean checkStudentGrade(String grade) {
        if (grade.endsWith("班")) {
            System.out.println("输入的班级合法");
            return true;
        } else {
            System.out.println("班级必须以“班”结束");
            return false;
        }
    }

    //年龄必须大于0且小于150
    private static boolean checkStudentAge(int age) {
        if (age < 0 || age > 150) {
            System.out.println("年龄必须大于0且小于150");
            return false;
        } else {
            System.out.println("输入的年龄合法");
            return true;
        }
    }

    //手机号的长度必须是11位，且必须以“138”，“136”，“158”，“133”开头
    private static boolean checkStudentPhone(String phone) {
        if (phone.length() == 11) {
            if (phone.startsWith("138") || phone.startsWith("136") || phone.startsWith("158") || phone.startsWith("133")) {
                System.out.println("输入的手机号合法");
                return true;
            }
        }
        System.out.println("手机号的长度必须是11位，且必须以“138”，“136”，“158”，“133”开头");
        return false;

    }

}