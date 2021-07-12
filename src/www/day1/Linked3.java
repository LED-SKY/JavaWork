package www.day1;

public class Linked3 {
    public static void main(String[] args) {

        Node zs = new Node("zs");
        Node ls = new Node("ls");
        Node wu = new Node("wu");
        Node zl = new Node("zl");

        zs.next = ls;
        ls.next = wu;
        wu.next = zl;


//        String str = wu.str;
//        String str = ls.next.str;
        String str = zs.next.next.str;
        System.out.println(str);


//        System.out.println(zs.next);

        String[] strs = new String[1000];

        strs[500] = "zs";
        System.out.println(strs[500]);

    }
}

// 定义一个链表的结点
class Node{
    String str;
    Node next;
    public Node(String str) {
        this.str = str;
    }
}
