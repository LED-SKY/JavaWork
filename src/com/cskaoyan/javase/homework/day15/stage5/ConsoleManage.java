package com.cskaoyan.javase.homework.day15.stage5;


import com.cskaoyan.javase.homework.day15.stage5.entity.Student;
import com.cskaoyan.javase.homework.day15.stage5.entity.StudentList;
import com.cskaoyan.javase.homework.day15.stage5.utils.ScannerUtils;

import java.util.Arrays;

/**
 * @description: 小练习阶段三
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class ConsoleManage {
    //学生列表对象 需要在这个类中使用，所以作为它的成员变量
    //默认的长度是10
    private StudentList sls = new StudentList(10);

    //默认无参构造里，加几个Student对象作为数组的初始值
    public ConsoleManage() {
        Student s1 = new Student(3, "张三", "男", "A班", 12, "18888888888");
        Student s2 = new Student(2, "李四", "女", "B班", 28, "13877777777");
        Student s3 = new Student(1, "上官第一", "男", "E班", 17, "13877777777");
        Student s4 = new Student(4, "李淳罡", "男", "B班", 89, "13877771777");
        Student s5 = new Student(6, "叶不凡", "女", "C班", 70, "13812777777");
        Student s6 = new Student(7, "碧瑶", "女", "B班", 20, "13877777777");
        //调用方法 加进数组中
        sls.createStudent(s1);
        sls.createStudent(s2);
        sls.createStudent(s3);
        sls.createStudent(s4);
        sls.createStudent(s5);
        sls.createStudent(s6);
    }

    public static void main(String[] args) {
        ConsoleManage cm = new ConsoleManage();
        cm.start();
    }


    public void start() {
        //该标志指示循环是否继续进行,即是否仍然输出菜单
        boolean loopFlag = true;
        while (loopFlag) {
            //调用方法,输出菜单
            showMenu();
            //键盘录入 选择对应功能
            int input = ScannerUtils.getMenuByScanner();
            switch (input) {
                case 1:
                    consoleGetAllStudent();
                    break;
                case 2:
                    consoleCreateStudent();
                    break;
                case 3:
                    consoleDeleteStudent();
                    break;
                case 4:
                    consoleUpdateStudent();
                    break;
                case 5:
                    consoleRetrieveStudent();
                    break;
                case 6:
                    consoleSortStudent();
                    break;
                case 7:
                    int quitFlag = ScannerUtils.getFlagByScanner();
                    if (quitFlag == 1) {
                        loopFlag = false;
                        System.out.println("感谢使用本系统！");
                        break;
                    }
                    System.out.println("欢迎继续使用！");
                    break;
            }
        }
    }

    private void consoleSortStudent() {
        System.out.println("---------------------------学生数组排序---------------------------");
        System.out.println("请选择排序的规则：");
        System.out.println("1，按照年龄升序排列！");
        System.out.println("2，按照学号升序排列！");
        int sortNum = ScannerUtils.getSortNumByScanner();
        //调用方法获取学生对象数组，数组中没有null
        Student[] allStudent = sls.getAllStudent();
        switch (sortNum) {
            case 1:
                //按照年龄从小到大排序，升序排列
                sortByAgeAscending(allStudent);
                break;
            case 2:
                //按照学号从小到大排序，升序排列
                sortByStuIdAscending(allStudent);
                break;
        }
    }

    private void sortByStuIdAscending(Student[] allStudent) {
        Arrays.sort(allStudent,(o1, o2) -> o1.getStuId() - o2.getStuId());
        System.out.println("学号\t姓名\t性别\t\t年级\t\t年龄\t\t电话号码");
        for (int i = 0; i < allStudent.length; i++) {
            allStudent[i].printStudent();
        }
    }

    private void sortByAgeAscending(Student[] allStudent) {
        Arrays.sort(allStudent,(o1,o2) -> o1.getAge() - o2.getAge());
        System.out.println("学号\t姓名\t性别\t\t年级\t\t年龄\t\t电话号码");
        for (int i = 0; i < allStudent.length; i++) {
            allStudent[i].printStudent();
        }
    }

    private void consoleRetrieveStudent() {
        //首先要通过键盘录入获得一个学号
        int targetStuId;
        //while (true){
        //    try {
        //        targetStuId =  ScannerUtils.getStuIdByScanner();
        //    } catch (NumberFormatException e) {
        //        System.out.println("请不要输入非数值，请重新输入！");
        //        continue;
        //    }
        //    break;
        //}
        targetStuId =  ScannerUtils.getStuIdByScanner();
        Student targetStudent = sls.retrieveStudent(targetStuId);
        if (targetStudent == null) {
            System.out.println("未查找到该学号的学生!");
            return;
        }
        System.out.println("学号\t姓名\t性别\t\t年级\t\t年龄\t\t电话号码");
        targetStudent.printStudent();
    }

    private void consoleUpdateStudent() {
        //首先要通过键盘录入获得一个学号
        int targetStuId = ScannerUtils.getStuIdByScanner();
        //用对象来查找修改
        if (sls.judgeStuIdExist(targetStuId)) {
            //学号存在,可以修改
            System.out.println("该学生存在！开始进行修改！");
            Student updateStu = ScannerUtils.getStudentInstanceByScanner(sls);
            /*
            由于工具类做出了修改 已经无需再去判断学号是否重复了
            这里一定会正常录入一个Student对象
            if (updateStu == null){
                //表示用户再次录入了重复的学号
                System.out.println("该学号已存在!");
                return;
            }*/
            if (sls.updateStudent(targetStuId, updateStu)) {
                System.out.println("学生信息修改成功!");
                return;
            }
        }
        //学号不存在,无法修改
        System.out.println("学生信息修改失败!");
    }

    private void consoleDeleteStudent() {
        //首先要通过键盘录入获得一个学号
        int targetStuId = ScannerUtils.getStuIdByScanner();
        //用对象来删除
        if (sls.deleteStudent(targetStuId)) {
            //方法返回true 表示删除成功
            System.out.println("学号为:" + targetStuId + "的学生已经删除成功！");
        } else {
            //方法返回false，表示未找到
            System.out.println("学号为:" + targetStuId + "的学生未找到！");
        }

    }

    private void consoleGetAllStudent() {
        System.out.println("---------------------------学生列表---------------------------");
        //调用方法获取学生对象数组
        Student[] allStudent = sls.getAllStudent();
        if (allStudent.length == 0) {
            //没有记录!
            System.out.println("没有学生信息记录!");
        } else {
            System.out.println("学号\t姓名\t性别\t年级\t\t年龄\t\t电话号码");
            for (int i = 0; i < allStudent.length; i++) {
                allStudent[i].printStudent();
            }
        }
    }

    private void consoleCreateStudent() {
        System.out.println("---------------添加学生信息-------------------");
        //调用工具类中的方法,得到一个学生对象
        //该方法如果返回null 表示输入的学号是重复的
        Student s = ScannerUtils.getStudentInstanceByScanner(sls);
        //学号重复应该结束方法，友好提示用户
        /*if (s == null) {
            System.out.println("您输入的学号已重复，请重新输入!");
            return;
        }*/
        //将该对象放进sls对象的数组中
        if (sls.createStudent(s)) {
            //方法返回true 表示存入学生信息成功
            System.out.println("存入信息成功!");
        } else {
            System.out.println("存入失败,可能是数组空间已满!");
        }
    }

    private void showMenu() {
        System.out.println("\n-----------------王道Java学生管理系统-----------------\n");
        System.out.println("                   1.学 生 列 表");
        System.out.println("                   2.增 加 学 生");
        System.out.println("                   3.删 除 学 生");
        System.out.println("                   4.修 改 学 生");
        System.out.println("                   5.查 询 学 生");
        System.out.println("                   6.排 序 学 生");
        System.out.println("                   7.退 出 系 统\n");
    }

}
