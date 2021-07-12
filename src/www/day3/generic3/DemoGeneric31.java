package www.day3.generic3;

public class DemoGeneric31 {
    public static void main(String[] args) {

        User1<Integer> user1 = new User1<Integer>("zs", 18);
        Integer age = user1.getAge();



    }
}

// T : type
// E : element
// K : key
// V : value
class User1 <T>{
    private String name;
    private T age;

    public User1(String name, T age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }
}
