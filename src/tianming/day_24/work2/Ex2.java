package tianming.day_24.work2;

public class Ex2 {
    public static void main(String[] args) {

        Node2 node1 = new Node2("1", null);
        Node2 node2 = new Node2("2", node1);
        Node2 node3 = new Node2("3", node2);
        Node2 node4 = new Node2("4", node3);
        Node2 node5 = new Node2("5", node4);
        Node2 node6 = new Node2("6", node5);
        Node2 node7 = new Node2("7", node6);

        // 7 -- 6 --5  --4  --3  --2  --1
        node1.next = node5;

        Node2 f = node7;
        Node2 l = node7;

        while (f.next != null && f.next.next != null){
            f = f.next.next;
            l = l.next;
            if (f == l){// 快指针和慢指针相遇, 必定意味着有环
                break;
            }
        }

        if (f.next != null && f.next.next != null){
            System.out.println("有环");
        } else {
            System.out.println("没有环");
        }
    }
}

class Node2{
    String value;
    Node2 next;
    public Node2(String value, Node2 next) {
        this.value = value;
        this.next = next;
    }
}
