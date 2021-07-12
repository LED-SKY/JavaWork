package tianming.day_24.work1;

/**
 * @program: Stage1
 * @description: 写方法求链表中间节点的元素
 * @author: 邓造坚
 * @create: 2021-07-06 19:40
 **/
public class Work1 {
    //找到中间节点是第几个
    static int num = 1;
    //固定保留头结点
    static Node head;

    public static void main(String[] args) {
        Node node1 = new Node("zs");
        Node node2 = new Node("ls");
        Node node3 = new Node("zz");
        Node node4 = new Node("wu");
        Node node5 = new Node("hh");

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(node1 == node2);
        System.out.println("中间节点的元素为：" + getMid(node1));
    }

    static class Node {
        //链表每个节点的数据
        String data;
        //链表的下一个节点
        Node next;

        public Node(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data='" + data + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

    static String getMid(Node node) {
        //保留头结点
        if (num == 1) {
            head = node;
        }
        //判断有几个链表节点
        if (node.next != null) {
            num++;
            getMid(node.next);
        }
        //找到最后一个节点则返回，递归出口
        if (node.next == null) {
            return null;

        }
        //定位中间节点并输出
        node = head;
        for (int i = 0; i < num / 2; i++) {
            node = node.next;
        }
        return node.data;

    }
}