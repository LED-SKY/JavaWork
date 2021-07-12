package www.day1;

public class Linked7 {
    public static void main(String[] args) {


        // zs  -- ls - wu  -- zl
        DBNode zs = new DBNode("zs", null, null);
        DBNode ls = new DBNode("ls", zs, null);
        DBNode wu = new DBNode("wu", ls, null);
        DBNode zl = new DBNode("zl", wu, null);

        //
//         zs.next = ls;
//         ls.next = wu;
//         wu.next = zl;


    }
}
