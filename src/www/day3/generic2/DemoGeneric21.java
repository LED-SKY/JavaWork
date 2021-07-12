package www.day3.generic2;

public class DemoGeneric21 {
    public static void main(String[] args) {

        User user = new User();
        user.setAge(10);


        String age = (String) user.getAge();



    }
}
class User{
    private String name;
    private Object age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getAge() {
        return age;
    }

    public void setAge(Object age) {
        this.age = age;
    }
}
