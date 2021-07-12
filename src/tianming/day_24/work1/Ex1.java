package tianming.day_24.work1;

/**
 * 求链表的中间元素
 */
public class Ex1 {
    public static void main(String[] args) {

        //头插法   头结点为node7   尾结点为node1
        Node1 node1 = new Node1("1", null);
        Node1 node2 = new Node1("2", node1);
        Node1 node3 = new Node1("3", node2);
        Node1 node4 = new Node1("4", node3);
        Node1 node5 = new Node1("5", node4);
        Node1 node6 = new Node1("6", node5);
        Node1 node7 = new Node1("7", node6);
        Node1 node8 = new Node1("8", node7);
        Node1 node9 = new Node1("9", node8);
        Node1 node10 = new Node1("10", node9);
        // 7 -- 6 --5  --4  --3  --2  --1
        // 快慢指针:
        Node1 f = node10;// 快指针
        Node1 l = node10;// 慢指针
        // 判断快指针的下一个元素, 以及下下个元素, 是不是null, 不是null向后继续移动
        //追及问题，当快指针走到终点时，慢指针只走了所有元素的一半，因为快指针一次走两步，慢指针一次走一步
        while (f.next != null && f.next.next != null){
            f = f.next.next;// 移动两步
            l = l.next; // 移动一步
        }

        // f接近于于尾部的时候, 跳出上述循环
        System.out.println(l.value);

    }
}
class Node1{
    String value;
    Node1 next;
    public Node1(String value, Node1 next) {
        this.value = value;
        this.next = next;
    }
}
