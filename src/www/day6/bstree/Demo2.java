package www.day6.bstree;

import java.util.ArrayList;

public class Demo2 {
    public static void main(String[] args) {

        MyBSTree<Integer> tree = new MyBSTree<>();

        //后序: [-2, -1, 0, 1, 6, 7, 5, 13, 11, 20, 15, 10]
        ArrayList<Integer> postOrder = new ArrayList<>();
        postOrder.add(-2);
        postOrder.add(-1);
        postOrder.add(0);
        postOrder.add(1);
        postOrder.add(6);
        postOrder.add(7);
        postOrder.add(5);
        postOrder.add(13);
        postOrder.add(11);
        postOrder.add(20);
        postOrder.add(15);
        postOrder.add(10);

        //中序: [-2, -1, 0, 1, 5, 6, 7, 10, 11, 13, 15, 20]
        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrder.add(-2);
        inOrder.add(-1);
        inOrder.add(0);
        inOrder.add(1);
        inOrder.add(5);
        inOrder.add(6);
        inOrder.add(7);
        inOrder.add(10);
        inOrder.add(11);
        inOrder.add(13);
        inOrder.add(15);
        inOrder.add(20);
        tree.buildTreeByPostAndInOrder(postOrder, inOrder);


        System.out.println(tree);


    }
}
