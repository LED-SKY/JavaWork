package www.day3.generic2;

public class DemoGeneric23 {
    public static void main(String[] args) {

        MyList<Integer> integerMyList = new MyList<>();
        integerMyList.add(10);


        MyList<User> userList = new MyList<>();
        userList.add(new User());
    }
}
