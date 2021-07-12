package www.day2.ex;

// 翻转单链表
public class Ex3 {
    public static void main(String[] args) {

        Node1 zl = new Node1("zl", null);
        Node1 wu = new Node1("wu", zl);
        Node1 ls = new Node1("ls", wu);
        Node1 zs = new Node1("zs", ls);

        // zs  --> ls --> wu  --> zl
        // zl  --> wu --> ls  --> zs

        Node1 reLinked = getReLinked(zs);
        System.out.println(reLinked);

        System.out.println(zs);

    }

    /**
     *  给定一个链表的头结点, 获得一个反序的链表
     * @param root: 头结点
     * @return:  反序链表的头结点
     */
    private static Node1 getReLinked(Node1 root) {
        Node1 mid = root;// 定义一个对原链表的遍历结点
        Node1 reLinked = null; // 反序链表的头结点

        while (mid != null){
            Node1 next = mid.next;
            mid.next = reLinked;
            reLinked = mid;
            mid = next;
        }

        return reLinked;
    }
}
