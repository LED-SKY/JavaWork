package www.day1;

public class Linked4 {
    public static void main(String[] args) {

        // 循环链表
        Node4 zs = new Node4("zs");
        Node4 ls = new Node4("ls");
        Node4 wu = new Node4("wu");
        Node4 zl = new Node4("zl");

        zs.next = ls;
        ls.next = wu;
        wu.next = zl;

        // zs  --> ls  ---> wu  ---> zl
        // System.out.println: 输出的一个对象的toString方法
        System.out.println(zs);


        // 构建一个循环链表
        zl.next = zs;

        System.out.println(zs);


    }


}



class Node4{
    String str;
    Node4 next;
    public Node4(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "{" +
                "str='" + str + '\'' +
                ", next=" + next +
                '}';
    }
}
