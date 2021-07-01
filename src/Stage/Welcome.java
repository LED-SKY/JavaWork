package Stage;

import Stage.entity.CRUD;
import Stage.entity.Student;
import Stage.utils.ScannerUtils;

import java.util.Scanner;

/**
 * @program: statge1
 * @description: 阶段三任务
 * @author: 邓造坚
 * @create: 2021-06-15 21:47
 **/
public class Welcome {
    //    可存储的 学生数量
    private static Student[] students = new Student[10];

    {
        Student stu1 = new Student(1, "张三", "男", 18, "Java", "16255421465");
        Student stu2 = new Student(3, "小黄", "女", 28, "C++", "18524569317");
        Student stu3 = new Student(2, "小黑", "男", 8, "C++", "17524269317");
        Student stu4 = new Student(4, "小黄", "女", 38, "C++", "13524269317");
        Student stu5 = new Student(5, "小包", "女", 5, "C++", "16524269317");
        students[0] = stu1;
        students[1] = stu2;
        students[2] = stu3;
        students[3] = stu4;
        students[4] = stu5;
    }

    public static void main(String[] args) {
        new Welcome();
        start();
    }

    //菜单界面
    public static void Menu() {
        System.out.println("--------------王道Java学生管理系统--------------");
        System.out.println("                    1.学生列表");
        String[] crud = new String[]{"增加", "删除", "修改", "查询", "排序"};
        for (int i = 0; i < crud.length; i++) {
            System.out.println("                    " + (i + 2) + "." + crud[i] + "学生");
        }

        System.out.println("                    7.退出系统");
        System.out.print("请选择功能（1-7）：");
    }


    //    开始界面逻辑
    public static void start() {
        int exitIn;
        int chooseIn;
        CRUD crud = new CRUD();
        crud.studs = students;

        while (true) {
            Menu();
            chooseIn = ScannerUtils.getMenuNumber();
            switch (chooseIn) {
                case 1:
                    System.out.println("进入学生列表功能");
                    crud.searchStudent();
                    break;
                case 2:
                    System.out.println("进入增加学生功能");
                    crud.addStudent();
                    break;
                case 3:
                    System.out.println("进入删除学生功能");
                    crud.deleterStudent();
                    break;
                case 4:
                    System.out.println("进入修改学生功能");
                    crud.updaterStudent();
                    break;
                case 5:
                    System.out.println("进入查询学生功能");
                    crud.searchAloneStudent();
                    break;
                case 6:
                    sortStudent(crud);
                    break;
                case 7:
                    System.out.println("确认退出吗（1/2）:");
                    exitIn = ScannerUtils.outSystem();
                    if (exitIn == 1) {
                        System.out.println("感谢使用本系统！");
                        System.exit(0);
                    } else if (exitIn == 2) {
                        System.out.println("欢迎重新进入本系统");
                        break;
                    }
                {
                    System.out.println("你输入的数字有误");
                }
                break;
                default:
                    System.out.println("请重新选择");
            }
        }
    }

    private static void sortStudent(CRUD crud) {
        System.out.println("进入排序学生功能");
        System.out.println("请选择按哪种方式来排序学生：");
        System.out.println("1.按照年龄从小到大排序    2.按照学号从小到大排序");
        Scanner sc = new Scanner(System.in);
        int num = 0;

        do {
            try {
                num = Integer.parseInt(sc.nextLine());
                if (num == 1 || num == 2) {
                    crud.sortStudent(num);
                    break;
                } else {
                    System.out.println("没有这个选项,请重新输入");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("你输入的选择不合规，请重新输入");
            }
        } while (true);
    }
}




