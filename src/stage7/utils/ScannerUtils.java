package stage7.utils;


import stage7.entity.Student;
import stage7.entity.StudentList;

import java.util.Scanner;

/**
 * @description: 键盘录入工具类
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class ScannerUtils {
    //需要一个Scanner对象,用来做键盘录入,用static修饰保证该对象唯一
    private static final Scanner sc = new Scanner(System.in);

    //私有化构造方法
    private ScannerUtils() {
    }


    //根据键盘录入,封装成一个Student对象并返回，但是要对学号做唯一性校验
    //需要传入使用的StudentList对象，进行校验
    public static Student getStudentInstanceByScanner(StudentList sls) {
        //为了避免Scanner有异常错误,全部采用nextLine()接收字符串,然后转换类型
        int stuId;
        while (true) {
            System.out.print("请输入合法的学号，要求大于0的整数并且不重复：");
            String tempStringStuId = sc.nextLine();
            try {
                stuId = Integer.parseInt(tempStringStuId);
            } catch (NumberFormatException e) {
                System.out.println("请不要输入非数值，请重新输入！");
                //tempStringStuId = sc.nextLine();
                continue;
            }
            //调用成员方法来判断stuId是否重复
            if (!sls.judgeStuIdRedundant(stuId)) {
                //不允许学号重复，友好提示用户做出修改
                System.out.println("学号已重复请重新录入！");
                continue;
            }
            if (!judgeStuIdLegal(stuId)) {
                //不允许学号小于0，友好提示用户做出修改
                System.out.println("学号必须大于0，请重新录入！");
                continue;
            }
            break;
        }


        String name;
        while (true) {
            System.out.print("请输入合法的姓名，长度在1到5之间：");
            name = sc.nextLine();
            if (!judgeNameLegal(name)) {
                //名字不合法，友好提示用户
                System.out.println("名字的长度必须在1到5之间，请重新输入！");
                continue;
            }
            break;
        }

        String gender;
        while (true) {
            System.out.print("请输入合法的性别，男和女之间选择：");
            gender = sc.nextLine();
            if (!judgeGenderLegal(gender)) {
                //性别不合法
                System.out.println("性别必须在男女之间选择！请重新录入！");
                continue;
            }
            break;
        }

        String grade;
        while (true) {
            System.out.println("请输入合法的班级，必须以xx班结尾：");
            grade = sc.nextLine();
            if (!judgeGradeLegal(grade)) {
                //班级不合法
                System.out.println("班级必须以xx班结尾，请重新录入！");
                continue;
            }
            break;
        }

        int age;
        while (true) {
            System.out.print("请输入合法的年龄，必须在1到150之间：");
            String tempStringAge = sc.nextLine();
            try {
                age = Integer.parseInt(tempStringAge);
            } catch (NumberFormatException e) {
                System.out.println("请不要输入非数值，请重新输入！");
                continue;
            }
            if (!judgeAgeLegal(age)) {
                //年龄不合法
                System.out.println("年龄必须在1到150之间！请重新录入！");
                continue;
            }
            break;
        }

        String phoneNum;
        while (true) {
            System.out.print("请输入要录入学生的电话号码，手机号的长度必须是11为，且开头是138,158,136,188：");
            phoneNum = sc.nextLine();
            if (!judgePhoneNumLegal(phoneNum)) {
                System.out.println("手机号有误，请重新输入！");
                continue;
            }
            break;
        }
        //创建对象,并返回
        return new Student(stuId, name, gender, grade, age, phoneNum);
    }

    private static boolean judgePhoneNumLegal(String phoneNum) {
        String[] arr = {"138", "158", "136", "188"};
        if (phoneNum.length() != 11) {
            return false;
        }
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (phoneNum.startsWith(arr[i])) {
                flag = true;
            }
        }
        return flag;
    }

    private static boolean judgeAgeLegal(int age) {
        if (age > 0 && age < 150) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean judgeGradeLegal(String grade) {
        if (grade.endsWith("班")) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean judgeGenderLegal(String gender) {
        if ("男".equals(gender) || "女".equals(gender)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean judgeNameLegal(String name) {
        if (name.length() > 1 && name.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean judgeStuIdLegal(int stuId) {
        return stuId > 0;
    }

    public static int getStuIdByScanner() {
        int stuId;
        while (true){
            System.out.println("请键盘录入一个学号：");
            String tempStringStuId = sc.nextLine();
            try {
                stuId = Integer.parseInt(tempStringStuId);
            } catch (NumberFormatException e) {
                System.out.println("请不要输入非数值，请重新输入！");
                continue;
            }
            break;
        }
        return stuId;
    }

    public static int getMenuByScanner() {
        int i;
        while (true) {
            System.out.print("请选择功能(1-7)：");
            try {
                i = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("请不要输入非数值，请重新输入！");
                continue;
            }
            if (i <= 0 || i > 7) {
                continue;
            }
            break;
        }
        return i;
    }

    public static int getFlagByScanner() {
        int i;
        while (true) {
            System.out.println("确认退出吗（1/2）：");
            try {
                i = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("请不要输入非数值，请重新输入！");
                continue;
            }
            if (i !=1 && i != 2) {
                continue;
            }
            break;
        }
        return i;
    }

    public static int getSortNumByScanner(){
        int i;
        while (true) {
            System.out.print("请选择要排序的规则(1-2)：");
            try {
                i = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("请不要输入非数值，请重新输入！");
                continue;
            }
            if (i <= 0 || i > 3) {
                continue;
            }
            break;
        }
        return i;
    }
}