package www.day2.ex;

public class Ex4 {
    public static void main(String[] args) {



        Node2 zl = new Node2("zl", null);
        Node2 wu = new Node2("wu", zl);
        Node2 ls = new Node2("ls", wu);
        Node2 zs = new Node2("zs", ls);
        Node2 aa = new Node2("aa", zs);

        // aa - zs  - ls  - wu  -zl -ls
        zl.next = wu;

        String value = getCircleFirstValue(aa);

        System.out.println(value);

    }

    /**
     *  给定一个链表的头结点(链表有环), 获得环起始位置的值
     * @param root: 链表头结点
     * @return : 环的起始位置结点的值
     */
    private static String getCircleFirstValue(Node2 root) {
        Node2 f = root;
        Node2 l = root;

        while (f.next != null && f.next.next != null){
            f = f.next.next;
            l = l.next;

            if (f == l){
                // 本来快指针应该走的更快, 但是走完某一步之后发现
                // 快指针和慢指针走到一起去了 ---> 意味着有环
                // 相遇, f, l在某个位置相遇了
               break;
            }
        }

        f = root;
        while (f != l){
            f = f.next;
            l = l.next;
        }


        return l.value;
    }
}
