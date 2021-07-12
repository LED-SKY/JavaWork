package www.day6.bstree;

import java.util.List;

public class Demo1 {
    public static void main(String[] args) {

        MyBSTree<Integer> tree = new MyBSTree<>();

        tree.add(10);
        tree.add(5);
        tree.add(7);
        tree.add(1);
        tree.add(15);
        tree.add(11);
        tree.add(20);
        tree.add(13);
        tree.add(6);
        tree.add(0);
        tree.add(-1);
        tree.add(-2);


//        tree.remove(13);


        //后序: [-2, -1, 0, 1, 6, 7, 5, 13, 11, 20, 15, 10]
        //中序: [-2, -1, 0, 1, 5, 6, 7, 10, 11, 13, 15, 20]
        System.out.println(tree.postOrder());
        System.out.println(tree.inOrder());
    }
}
