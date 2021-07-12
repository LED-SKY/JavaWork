package tianming.day_28.tree;

import java.util.List;

/**
 * @program: Stage1
 * @description: 二叉搜索树的实现
 * @author: 邓造坚
 * @create: 2021-07-10 11:33
 * <p>
 * 1.集合类：数据容器
 * 2.底层结构：链表
 **/
public class MyBSTree<T>  {
    Node root;//树的根节点

    private int size;

    //在二叉搜索树中添加一个节点或值
    public boolean add(T value) {
        //不允许在二叉搜索树存null，因为null没办法比较大小
        if (value == null) throw new RuntimeException("parame is null");

        //判断源树是否为空
        if (isEmpty()) {
            //源树为空，没有存储任何元素，新元素作为根结点
            root = new Node(value);
            size++;
            return true;
        }
        //源树不为空，找到一个存储位置。找法：按照大小从左右方向上查找比较
        Node mid = root;//当前遍历结点
        //保存遍历结点的父节点
        Node midF = null;
        //比较的值
        int com = 0;
        while (mid != null) {
            //保存mid的父结点
            midF = mid;
            //比较value和当前结点的value大小

            if (com > 0) {
                //value比当前结点大，向右边查找
                mid = mid.right;
            }
            if (com < 0) {
                //value比当前结点小，向左边查找
                mid = mid.left;
            }
            //com == 0 意味着value和当前结点的value是一样的，要添加的元素已经存在，所以不能添加
            return false;

        }
        //midF 就是要添加位置的父结点,循环出来表示在树上没有相同的结点值，可以添加
        if (com > 0) {
            //最后一次比较，value值大
            midF.right = new Node(value);
        } else {
            //最后一次比较，value值小
            midF.left = new Node(value);
        }
        size++;
        return true;
    }

    //删除
    public boolean remove(T value) {
        //不允许在二叉搜索树存null，因为null没办法比较大小
        if (value == null) throw new RuntimeException("parame is null");
        //判断源树是否为空
        if (isEmpty()) throw new RuntimeException("tree is empty");
        //查找删除的结点
        Node mid = root;//遍历结点（用于查找要删除的结点）
        Node midF = null;//遍历结点的父结点
        int com = 0;
        while (mid != null) {

            midF = mid;//记录父结点位置
            if (com == 0) {
                //mid就是要删除的元素
            }else if (com >0){
                //value 比较大，如果这个value存在在二叉搜索树，应该在此时mid的right
            }
        }
        return true;
    }

    //是否存在
    public boolean contains(T value) {
        return true;
    }

    // 前序：栈，递归
    // 中序：栈，递归
    // 后序：栈，递归

    //前序
    public List<T> preOrder() {
        return null;
    }

    // 层级遍历：队列
    // 建树操作：前序 + 中序
    // 建树操作：后序 + 中序

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }



    class Node{
        T value;
        Node left;
        Node right;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    
}
