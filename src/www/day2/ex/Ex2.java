package www.day2.ex;

// 判断链表中是否有环(circle)
public class Ex2 {
    public static void main(String[] args) {

        Node2 zl = new Node2("zl", null);
        Node2 wu = new Node2("wu", zl);
        Node2 ls = new Node2("ls", wu);
        Node2 zs = new Node2("zs", ls);
        Node2 aa = new Node2("aa", zs);

        // aa - zs  - ls  - wu  -zl
        zl.next = ls;

        boolean bool = hasCircle(aa);
        System.out.println(bool);



    }

    /**
     * 判断链表中是否有环
     * @param root :  链表的头结点
     * @return :  是否有环
     */
    private static boolean hasCircle(Node2 root) {
        Node2 f = root;
        Node2 l = root;

        while (f.next != null && f.next.next != null){
            f = f.next.next;
            l = l.next;

            if (f == l){
                // 本来快指针应该走的更快, 但是走完某一步之后发现
                // 快指针和慢指针走到一起去了 ---> 意味着有环
                return true;
            }
        }

        return false;
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
