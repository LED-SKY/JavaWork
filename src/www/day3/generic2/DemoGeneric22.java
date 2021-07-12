package www.day3.generic2;

public class DemoGeneric22 {
    public static void main(String[] args) {

//        泛型，即“参数化类型”。顾名思义，
//        就是将类型由原来的具体的类型'参数化'，
//        此时类型也定义成参数形式，然后在使用/调用时传入具体的类型。
//        对于某种类型事先不固定, 当我们使用的时候,再(像传入参数一样)传入类型


        User2<String> user21 = new User2<>();
        user21.setAge("10");
        String age = user21.getAge();


        User2<Integer> user22 = new User2<>();
        user22.setAge(10);
        Integer age1 = user22.getAge();



    }
}

class User2<XXXXXXXX> {
    String name;
    XXXXXXXX age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public XXXXXXXX getAge() {
        return age;
    }

    public void setAge(XXXXXXXX age) {
        this.age = age;
    }
}
