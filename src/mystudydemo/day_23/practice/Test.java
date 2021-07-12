package mystudydemo.day_23.practice;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-05 09:58
 **/
public class Test {
    public static void main(String[] args) {
        new  Student(29);
    }
}
class  Student{
    int num;

    public Student() {
        System.out.println("调用了无参构造方法");
    }

    public Student(int num) {
        
        this.num = num;
        System.out.println("调用了有参构造方法");

    }
}