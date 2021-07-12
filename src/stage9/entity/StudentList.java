package stage9.entity;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @description: 存学生对象的类，包括对这些对象的操作
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

public class StudentList {
    //获取Class对象
   private Class<?> studentClass = Class.forName("stage9.entity.Student");
    private Student[] studs;

    //为了方便明确的知道数组中有多少有效的学生对象,需要一个指示器
    //需要一个静态成员
    private static int count = 0;
//    private static boolean isWrite = true;

    //构造方法
    public StudentList(int stuNums) throws ClassNotFoundException {

        
        this.studs = new Student[stuNums];
    }
 
    //私有化无参构造,禁止无参创建对象导致数组未初始化
    private StudentList() throws ClassNotFoundException {
    }

    //该类需要完成对studs数组的增删改查 四个基本操作，并且可以打印输出所有学生的信息

    //新增学生信息
    public boolean createStudent(Student s) {
        //该方法为新增学生信息，而不是修改或者覆盖，也就是说只有当数组中有null的位置的时候才能新增学生
        //遍历数组，找到null的位置
        
        for (int i = 0; i < studs.length; i++) {
            
            if (studs[i] == null) {
                //找到第一个等于null的位置的下标i
                //把方法的参数学生对象 装入数组中
                studs[i] = s;
                //输出提示语句：存入学生信息成功！
                //System.out.println("存入学生信息成功！");
                StudentList.count++;
                return true; //表示存入成功
            }
        }
        //程序执行到这里还没结束，表示数组满了，不能装了，提示用户，并返回false
        //System.out.println("数组已满，无法存入学生信息！");
        return false;
    }

    //删除学生信息，实质上是把某个学生对象的引用置为null
    //该方法需要传入一个学号 作为删除的依据
    public boolean deleteStudent(int targetStuId) {
        //遍历数组，通过学号找到该学生对象
        for (int i = 0; i < studs.length; i++) {
            //跳过为null的元素
            if (studs[i] == null) {
                continue;
            }
            //查找
            if (studs[i].getStuId() == targetStuId) {
                //找到了，把该元素置为null
                studs[i] = null;
                //删除元素后，不要忘记了把静态变量数组的长度-1
                StudentList.count--;
                return true;
            }
        }
        //程序执行到这里，说明通过id没有找到元素
        return false;
    }

    //修改某个学生信息
    //根据学号查到学生,然后键盘录入学生对象,替代它
    public boolean updateStudent(int targetStuId, Student updateStu) {
        //如果用户再次录入已存在的学号，会传入一个nullStudent对象
        if (updateStu == null){
            //无需赋值
            return false;
        }
        //遍历数组，通过学号找到该学生对象
        for (int i = 0; i < studs.length; i++) {
            //跳过为null的元素
            if (studs[i] == null) {
                continue;
            }
            //查找
            if (studs[i].getStuId() == targetStuId) {
                //找到了这个学号的学生,修改它
                studs[i] = updateStu;
                return true;
            }
        }
        //没找到对应学号的学生
        return false;
    }

    //查找某个学生
    public Student retrieveStudent(int targetStuId) {
        //先查看targetStuId是否存在
        int targetIndex = getIndex(targetStuId);
        if (targetIndex == -1) {
            //学号不存在
            return null;
        }
        return studs[targetIndex];
    }

    //返回装有全部有效学生信息的数组
    //不会返回null
    public Student[] getAllStudent()  {
     
        
        //如果当前数组为null或者长度为0 返回长度为0的数组
        if (studs == null || studs.length == 0) {
            return new Student[0];
        }
        //程序执行到这里 数组都是正常的数组了
        //这里需要剔除数组中等于null的元素,然后把有效学生对象放入数组
        Student[] returnStuds = new Student[StudentList.count]; //count表示有效对象个数
        //注意学生数组的有效长度是根据returnStuds来定的，所以最多只能遍历它长度的数组
        //但是又需要全部遍历整个存学生的数组，需要用嵌套for循环
        int start = 0;
        for (int i = 0; i < returnStuds.length; i++) {
            for (int j = start; j < studs.length; j++) {
                if (studs[j] != null) {
                    returnStuds[i] = studs[j];
                    start = j + 1;
                    break;
                }
            }
        }
        return returnStuds;
    }
    //通过反射来创建student对象
    public Student getStudentClass() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //通过无参构造方法，创建对象
        Constructor<?> stuCon   = studentClass.getDeclaredConstructor();
        stuCon.setAccessible(true);
        Object o = stuCon.newInstance();
        return ((Student) o);
    }
    
    
    //从文件中读取学生信息
    public void getFileStudent() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        
        BufferedReader in = new BufferedReader(new FileReader("Student.txt"));
        String line = null;
        int count=0;
        while ((line = in.readLine()) !=  null){
            count++;
            Student student = getStudentClass();
            String[] tempLine = line.split("，");
            int stuId = Integer.parseInt(tempLine[0].substring(6));

            Field stuId1 = studentClass.getDeclaredField("stuId");
            stuId1.setAccessible(true);
            stuId1.set(student,stuId);
//            student.setStuId(stuId);
            
            String name = tempLine[1].substring(5);

            Field name1 = studentClass.getDeclaredField("name");
            name1.setAccessible(true);
            name1.set(student,name);
            
//            student.setName(name);
            String gender = tempLine[2].substring(7);

            Field gender1 = studentClass.getDeclaredField("gender");
            gender1.setAccessible(true);
            gender1.set(student,gender);


//            student.setGender(gender);
            String grade = tempLine[3].substring(6);

            Field grade1 = studentClass.getDeclaredField("grade");
            grade1.setAccessible(true);
            grade1.set(student,grade);
            
//            student.setGrade(grade);
            int age = Integer.parseInt(tempLine[4].substring(4));

            Field age1 = studentClass.getDeclaredField("age");
            age1.setAccessible(true);
            age1.set(student,age);

//            student.setAge(age);
            String phoneNum = tempLine[5].substring(9);

            Field phoneNum1 = studentClass.getDeclaredField("phoneNum");
            phoneNum1.setAccessible(true);
            phoneNum1.set(student,phoneNum);
//            student.setPhoneNum(phoneNum);
            createStudent(student);
        }
        in.close();
        
    }
//    将内存中的数据写入到文件中
    public  void setFileStudent()throws IOException{
        BufferedWriter out = new BufferedWriter(new FileWriter("Student.txt"));
        Student[] outStudent = getAllStudent();

        for (Student s : outStudent) {
            out.write(s.toString());
            out.write(System.lineSeparator());
        }
        out.close();
    }
    //对学号进行校验，返回一个布尔类型的取值，true表示学号可以使用
    //false表示学号已重复禁止使用
    public boolean judgeStuIdRedundant(int targetStuId) {
        //遍历studs数组，但是要注意数组中是null的元素
        for (int i = 0; i < studs.length; i++) {
            if (studs[i] == null) {
                continue;
            }
            if (studs[i].getStuId() == targetStuId) {
                //表示学号已重复
                return false;
            }
        }
        //只要不从if中结束方法，说明学号还未重复
        return true;
    }

    //提供一个方法用来查找数组中是否存在对应的学号
    public boolean judgeStuIdExist(int targetStudId) {
        //遍历数组
        for (int i = 0; i < studs.length; i++) {
            if (studs[i] == null) {
                continue;
            }
            if (studs[i].getStuId() == targetStudId) {
                return true;
            }
        }
        return false;
    }

    //通过传入的学号查找下标,该方法私有,供内部使用
    private int getIndex(int targetStuId) {
        int targetIndex = -1;
        for (int i = 0; i < studs.length; i++) {
            if (studs[i] == null) {
                continue;
            }
            if (studs[i].getStuId() == targetStuId) {
                targetIndex = i;
            }
        }
        return targetIndex;
    }

   
}
