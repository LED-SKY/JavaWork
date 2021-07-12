package tianming.day_24.practice;

import javax.sound.midi.Soundbank;

/**
 * @program: Stage1
 * @description: 双向链表
 * @author: 邓造坚
 * @create: 2021-07-06 17:35
 **/
public class Demo2 {
    public static void main(String[] args) {
        //不能用toString方法打印
        Node n1 = new Node("1", null, null);
        Node n2 = new Node("2", null, null);
        Node n3 = new Node("3", null, null);
        n1.next = n2;
        n2.pre = n1;

        n2.next = n3;
        n3.pre = n2;
        System.out.println(n1);

    }
    
    static  class Node{
        String data; //数据
        Node pre;   //前指针指向
        Node next;  //后指针指向

        public Node(String data, Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data='" + data + '\'' +
                    ", pre=" + pre +
                    ", next=" + next +
                    '}';
        }
    }
}
