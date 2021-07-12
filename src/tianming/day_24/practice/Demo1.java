package tianming.day_24.practice;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-06 09:27
 * 
 * 单向链表
 **/
public class Demo1 {
    public static void main(String[] args) {
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("3");
        n1.next  = n2;
        n2.next  = n3;
        n3.next  = n4;
        n4.next  = n3;
        System.out.println(n3.hashCode());
        System.out.println(n1.hashCode());
        System.out.println(n4.next.hashCode());
//        System.out.println(n1);
    }
    static class Node{
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
        }

        public Node(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data='" + data + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
}
