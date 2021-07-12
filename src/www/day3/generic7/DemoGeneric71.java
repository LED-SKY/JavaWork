package www.day3.generic7;

import java.util.ArrayList;

public class DemoGeneric71 {
    public static void main(String[] args) {

        User<String> zs = new User<>("zs", "18");
        String age = zs.age;

        User<Integer> ls = new User<>("ls", 18);
        Integer age1 = ls.age;
        ls.age = 18;

        //

        //下面代码报错:  泛型必须是引用类型
//        User<int> ls2 = new User<>("ls", 18);


//        ArrayList<String> list = new ArrayList<>();



    }
}

class User<T>{
    String name;
    T age;

    public User(String name, T age) {
        this.name = name;
        this.age = age;

    }
}
//--------------------
//class User{
//    String name;
//    String age;
//}
//class User{
//    String name;
//    Integer age;
//}



