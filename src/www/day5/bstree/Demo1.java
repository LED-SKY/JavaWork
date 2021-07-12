package www.day5.bstree;

import java.util.List;

public class Demo1 {
    public static void main(String[] args) {

//        MyBSTree<User> myBSTree = new MyBSTree<>();
//        myBSTree.add(new User());
//        myBSTree.remove(new User());
//
//        //
//        String zs = "zs";
//        String ls = "ls";
//        int compareTo = zs.compareTo(ls);
//        System.out.println(compareTo);


        // 在java中, 所谓"自然顺序" 实现了Comparable的compareTo方法,
        // 通过这个方法, 比较的大小结果, 就是java的自然顺序

//        User zs = new User("zs", 18);
//        User wu = new User("wu", 20);
//        int compareTo = zs.compareTo(wu);
//        System.out.println(compareTo);




//        MyBSTree<A> myBSTree = new MyBSTree<>();
//        myBSTree.add(new A());
//        myBSTree.remove(new A());

        MyBSTree<String> myBSTree = new MyBSTree<>();
        myBSTree.add("zs");
        myBSTree.add("ls");
        myBSTree.add("wu");
        myBSTree.add("zl");

        List<String> list = myBSTree.preOrder();

        System.out.println(list);

    }
}
class User implements Comparable<User>{
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        int com = o.name.compareTo(name);
        com = com == 0 ? o.age  - age : com;

        return com;
    }
}


class A {}
