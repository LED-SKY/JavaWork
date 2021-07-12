package www.day1;

public class Linked5 {
    public static void main(String[] args) {

        DBNode zs = new DBNode("zs", null, null);
        DBNode ls = new DBNode("ls", null, null);
        DBNode wu = new DBNode("wu", null, null);
        DBNode zl = new DBNode("zl", null, null);

        // zs -ls
        zs.next = ls;
        ls.pre = zs;

        // zs  -ls -wu
        ls.next = wu;
        wu.pre = ls;

        // zs - ls -wu -zl
        wu.next = zl;
        zl.pre = wu;

        System.out.println(zs);

        // 如果把上述双向链表变成一个双向循环链表的话
        zl.next =  zs;
        zs.pre  = zl;

    }
}

// 双向链表的结点
class DBNode{
    String value;// 结点的值域
    DBNode pre;// 结点的前指针域
    DBNode next; // 结点的后指针域

    public DBNode(String value, DBNode pre, DBNode next) {
        this.value = value;
        this.pre = pre;
        this.next = next;
    }

    @Override
    public String toString() {
        return "DBNode{" +
                "value='" + value + '\'' +
//                ", pre=" + pre +
                ", next=" + next +
                '}';
    }
}
