package www.day3.mydblinked;

import java.util.LinkedList;

public class Demo {
    public static void main(String[] args) {

        MyDBLinked linked = new MyDBLinked();

        linked.add(0, "zs");
        linked.add(0, "ls");
        linked.add(1, "wu");
        linked.add(3, "zl");

        // ls wu zs zl
        linked.remove(3);



        System.out.println(linked);


//        String [] strs = new String[Integer.MAX_VALUE/4];


        LinkedList<String> list = new LinkedList<>();
        list.add("zs");
        list.remove("zs");
        list.contains("zs");
        list.set(0, "aa");
        list.add(1, "ls");
        list.remove(0);
        list.get(0);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(10);

    }
}
