package Stage.entity;

/**
 * @program: statge1
 * @description: 学生实体类
 * @author: 邓造坚
 * @create: 2021-06-15 22:21
 **/
public class Student {


    private int stuId;
    private String name;
    private String sex;
    private int age;
    private String grade;
    private String phone;

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStuId() {
        return stuId;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public String getPhone() {
        return phone;
    }

    public Student() {
    }

    public Student(int stuId, String name, String sex, int age, String grade, String phone) {
        this.stuId = stuId;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.grade = grade;
        this.phone = phone;
    }

    public void PrintStudentMessage() {
        System.out.println("学号为：" + stuId + "  姓名：" + name + "  性别为：" + sex + "  年龄为：" + age + "  班级为：" + grade + "  手机号为：" + phone);
    }
}

