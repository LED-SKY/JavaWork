package www.day2.ex;

// 求链表的中间元素
// 判断链表中是否有环(circle)
// 反转单链表
// 使用链表/数组实现一个线性表
public class Ex1 {
    public static void main(String[] args) {

        Node1 zl = new Node1("zl", null);
        Node1 wu = new Node1("wu", zl);
        Node1 ls = new Node1("ls", wu);
        Node1 zs = new Node1("zs", ls);
        Node1 aa = new Node1("aa", zs);

        // 头插法
        String str = getMid(aa);

        System.out.println(str);


    }

    /**
     * 获取一个链表的中间结点
     * @param root:  链表的头结点
     * @return : 中间结点的值
     */
    private static String getMid(Node1 root) {
        Node1 f = root;// 快指针
        Node1 l = root;// 慢指针

        // 如果快指针的下一个要走的结点 , 和下下个要走的结点不是null
        // 意味着, 还没有到尾部
        while (f.next != null && f.next.next != null){
            f = f.next.next;
            l = l.next;
        }

        // 上述循环跳出条件: 到尾部  ---> 意味着慢指针到中间

        return l.value;
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
