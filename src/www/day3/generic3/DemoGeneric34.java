package www.day3.generic3;

public class DemoGeneric34 {
    public static void main(String[] args) {

        User4<String> user1 = new User4<>();
        String age = user1.age;

        User4<Integer> user2 = new User4<Integer>();

        User4 user4 = new User4();
        Object age1 = user4.age;


    }
}

class User4<T>{
    String name;
    T age;
}
