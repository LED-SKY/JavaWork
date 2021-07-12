package www.day2.mylinkedlist;

import java.util.LinkedList;

public class DemoMyLinkedList {
    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.add("zs");
        myLinkedList.add("ls");
        myLinkedList.add("wu");
        myLinkedList.add("zl");

        myLinkedList.add(4, "aa");

        // zs ls  wu  zl aa

        myLinkedList.remove(4);

        //zs ls  wu  zl

        myLinkedList.set(3, "aa");


        System.out.println(myLinkedList);

//        boolean zl = myLinkedList.contains("zl");
//        myLinkedList.set("zl", "aaa");



//        myLinkedList.remove("zs");
//        myLinkedList.contains("ls");
//        myLinkedList.set("ls", "aaa");
//
//        myLinkedList.add(1, "zs");
//        myLinkedList.remove(0);
//        myLinkedList.get(0);
//        myLinkedList.set(0, "zs");





    }
}
