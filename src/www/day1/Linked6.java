package www.day1;

public class Linked6 {
    public static void main(String[] args) {
//        求链表的中间元素
//        判断链表中是否有环(circle)
        Node zs = new Node("zs");
        Node ls = new Node("ls");
        Node wu = new Node("wu");
        Node zl = new Node("zl");
        zs.next = ls;
        ls.next = wu;
        wu.next = zl;

        // zs  - ls  - wu  -zl --aa


        // 参数: 链表的头结点
        // 返回值: 链表的中间结点的元素
        String value = getMid(zs);

        // 判断链表中是否有环(circle)

        //zs  -- ls  -- wu  --zl  ---ls  --wu  --zl....
        zl.next = ls;
        // 参数: 链表的头结点
        // 返回值: 是否有环
        boolean bool = hasCircle(zs);



        // ps选作: 给你链表的头结点(已知有环), 获得环的起始位置存储内容




//        if (false){
//            System.out.println("if");
//        }else if (true){
//            System.out.println("else if ");
//        }else {
//            System.out.println("else ");
//        }

    }

    private static boolean hasCircle(Node zs) {

        return false;
    }

    private static String getMid(Node zs) {


        return null;
    }
}
