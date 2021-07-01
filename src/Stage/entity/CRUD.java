package Stage.entity;

import Stage.utils.ScannerUtils;

import java.util.Arrays;

/**
 * @program: statge1
 * @description: 对学生类进行增删查改
 * @author: 邓造坚
 * @create: 2021-06-15 22:39
 **/
public class CRUD {
    public Student[] studs;

    public CRUD() {
    }

    public CRUD(Student[] studs) {
        this.studs = studs;
    }

    //增
    public void addStudent() {
        Student tempStudent = ScannerUtils.inputStudent(this);
        for (int i = 0; i < studs.length; i++) {

            if (tempStudent == null) {
                System.out.println("存入信息失败");
                return;
            } else if (studs[i] == null) {
                studs[i] = tempStudent;
                System.out.println("存入信息成功");
                return;
            }
        }
    }

    //删
    public void deleterStudent() {
        System.out.println("现在系统中拥有的学生为：");
        searchStudent();
        System.out.println("请输入你要删除的学生的学号：");
        int deleterId = getStudentIndex();
        if (deleterId == -1) {
            System.out.println("系统中没有这个学生，无法删除！");
        } else {
            studs[deleterId] = null;
            System.out.println("删除成功！");
        }

    }

    //查
    public void searchStudent() {

        for (Student s1 : studs) {
            if (s1 == null || s1.equals("")) {
                continue;
            }
            s1.PrintStudentMessage();
        }
        System.out.println();
    }

    //改
    public void updaterStudent() {
        System.out.println("请输入你要修改的学生的学号：");
        int updateId = getStudentIndex();
        if (updateId == -1) {
            System.out.println("系统中没有这个学生，无法修改学生信息！");
        } else {
            studs[updateId] = ScannerUtils.inputStudent(this);
            System.out.println("修改成功！");
        }
    }

    //    按照特定顺序排序学生
    public void sortStudent(int num) {

        if (num == 1) {
            Student[] arr = getStudentsArray();
            Arrays.sort(arr, (o1, o2) -> o1.getAge() - o2.getAge());
            for (int i = 0; i < arr.length; i++) {
                arr[i].PrintStudentMessage();
            }
        }else if (num == 2){
            Student[] arr = getStudentsArray();
            Arrays.sort(arr, (o1, o2) -> o1.getStuId() - o2.getStuId());
            for (int i = 0; i < arr.length; i++) {
                arr[i].PrintStudentMessage();
            }
        }
    }

    //提取不包含null的学生数组
    private Student[] getStudentsArray() {
        int count =0;

        for (int i = 0; i < studs.length; i++) {
            if (studs[i] == null || studs[i].equals("")) {
                continue;
            } else count++;
        }
        Student[] arr = new Student[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = studs[i];
        }
        return arr;
    }

    

    //查询某个特定的学生
    public void searchAloneStudent() {
        System.out.println("请输入要查询学生的学号：");
        int id = this.getStudentIndex();
        if (id > -1) {
            studs[id].PrintStudentMessage();
        } else {
            System.out.println("系统中无此学生！");
        }
    }


    //    判断学号是否重复
    public int judgeStuId() {
        int targetStuId = ScannerUtils.getStuId();
        for (int i = 0; i < studs.length; i++) {
            if (studs[i] != null) {
                if (targetStuId == studs[i].getStuId()) {
                    System.out.println("学号已重复，请重新输入!");
                    return -1;

                }
            }

        }
        return targetStuId;
    }

    //    查询已存在学生的下标
    private int getStudentIndex() {
        int targetStuId = ScannerUtils.getStuId();

        for (int i = 0; i < studs.length; i++) {
            if (studs[i] != null) {
                if (targetStuId == studs[i].getStuId()) {
                    return i;
                }
            }

        }
        return -1;
    }


}
