package www.day3.generic;

public class Demo1 {
    public static void main(String[] args) {

        MyList myList = new MyList();
        myList.add("zs");
        myList.add("zs");
        myList.add("zs");
        Object o = myList.get(0);
        String str = (String) o;


        MyList myclass = new MyList();
        myclass.add(new User());
        myclass.add(new User());
        User o1 = (User) myclass.get(0);



        //
        Object obj2 =  myclass.get(0);
        String o2 = (String)obj2;







        // 类型转化异常
//        Object obj = new User();
//        String  str2 = (String) obj;



    }
}

class User{
    String name;
    int age;
}
