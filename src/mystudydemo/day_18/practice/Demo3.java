package mystudydemo.day_18.practice;

import java.io.*;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-29 15:53
 * 序列化流，存进磁盘
 * 
 **/
public class Demo3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        serialize();
        //将对象从磁盘写入到内存 中
        //反序列化
        //创建一个反序列流对象
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("english.txt"));
        Student student = (Student) in.readObject();
        System.out.println(student);
        in.close();
    }
    private static void serialize() throws IOException {
        //学生对象信息写入文件
        //创建一个学生对象
        Student stu = new Student("李四", 18);
        //创建序列化流对象
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("english.txt"));
        //将writeObject(Object obj)   写入对象信息
        out.writeObject(stu);
    }
}
class Student implements Serializable{
    static final long serialVersionUID = 3398576661566586907L;

    String name;
    int age;
    transient int phone;
    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
