package tianming.day_25.work1;

import java.util.LinkedList;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-07 15:40
 **/
public class Work1 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.add("zs");
        myLinkedList1.add("ls");
        myLinkedList1.add("ws");
        myLinkedList1.add("ls");
       
        myLinkedList1.add("zz");
        myLinkedList1.Remove("ws");
        System.out.println(myLinkedList1.contains("ls"));
        System.out.println(myLinkedList1);

//        System.out.println(myLinkedList1.set("zs", "aaa"));
//        myLinkedList1.add(3,"ww");
//        myLinkedList1.remove(4);
//        System.out.println(myLinkedList1.get(0));
        myLinkedList1.set(2,"这哪是");
        String s = myLinkedList1.get(0);
        System.out.println(s);
        System.out.println(myLinkedList1);
        
        
    }
}
