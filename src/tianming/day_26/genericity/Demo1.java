package tianming.day_26.genericity;

/**
 * @program: Stage1
 * @description: 泛型测试练习
 * @author: 邓造坚
 * @create: 2021-07-08 15:14
 **/
public class Demo1 {
    public static void main(String[] args) {
        User<String> stringUser = new User<String>();
        stringUser.setAge("10");
        
    }
}
//  T  代表 泛型，根据具体使用的类型是什么类型它就是什么类型
class User<T>{
    private String name;
    private T age;

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
