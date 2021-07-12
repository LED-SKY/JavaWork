package www.day3.generic3;

public class DemoGeneric32 {
    public static void main(String[] args) {

        User2<String, Integer> zs = new User2<>("zs", 18);
        String name = zs.getName();
        Integer age = zs.getAge();


        User2<Integer, String> user2 = new User2<>(10, "18");
        Integer name1 = user2.getName();
        String age1 = user2.getAge();


    }
}

class User2 <T, E> {
    private T name;
    private E age;
    public User2(T name, E age) {
        this.name = name;
        this.age = age;
    }
    public T getName() {
        return name;
    }
    public void setName(T name) {
        this.name = name;
    }
    public E getAge() {
        return age;
    }
    public void setAge(E age) {
        this.age = age;
    }
}

