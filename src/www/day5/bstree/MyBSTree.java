package www.day5.bstree;

import java.util.List;

/**
 *  1, 集合类:  数据容器
 *  2, 底层结构:  链表
 *  3, 表示数据结构: 二叉搜索树,   (二叉,   有大小)
 *  // 因为二叉搜索树, 是对结点存储的值, 需要比较大小的
 *  // 也就意味着存储到二叉搜索树上的内容, 要可以比较大小
 */
public class MyBSTree<T extends Comparable<T>> {

    private Node root; // 二叉搜索树的根节点
    private  int size;

    // 对二叉搜索树的添加方法: 在二叉搜索树种添加一个结点/值
    public boolean add(T value) {
        return true;
    }
    // 对二叉搜索树的删除方法: 在二叉搜索树种删除一个结点/值
    public boolean remove(T value) {
        return true;
    }
    // 查找二叉搜索树中, 某个值是否存在
    public boolean contains(T value){
        return true;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    // --------------------------------------------------
    // 前序: 栈, 递归
    // 中序: 栈, 递归
    // 后序: 栈, 递归

    // 前序
    public List<T>  preOrder(){
        return null;
    }

    // 层级遍历: 队列

    // 建树操作: 前序+中序
    // 建树操作: 后序+中序

    //-----------------------------------------------

    class Node{
        T value;
        Node left;
        Node right;
        public Node(T value) {
            this.value = value;
        }
    }
}
