package www.day6.bstree;

import www.day2.mylinkedlist.MyLinkedList;
import www.day4.queue.MyArrayQueue;
import www.day4.stack.MyArrayStack;
import www.day4.stack.MyLinkedStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
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
        // 不允许在二叉搜索树中存储null值, 因为null没办法比较大小
        if(value == null) throw  new IllegalArgumentException("parame is null");

        // 判断添加的时候, 原树是否为空
        if (isEmpty()){
            // 原树为空, 没有存储任何元素, 新元素作为根节点
            root = new Node(value);
            size++;
            return true;
        }

        // 原树不空, 找到一个存储位置, 怎么找? 按照大小向左右方向上查找比较
        Node mid = root;// 当前遍历结点
        Node midF = null;// 保存遍历结点的父结点
        int com = 0;

        while (mid != null){

            com = value.compareTo(mid.value);
            midF = mid;
            if (com > 0){
                // value比较大, 如果要添加, 那么存在的位置,应该在mid的right方向
                mid = mid.right;

            }else if (com < 0){
                // value比较小, 如果要添加, 那么存在的位置,应该在mid的left方向
                mid = mid.left;

            }else{
                // com == 0 : 意味着, value 和 mid.value 是一样的
                //                   添加的这个元素, 已经存在于树上了


                // 拉链法
                // 计数法
                // 修正的BSTree


                // 如果添加的元素已经存在树上, 不再重复添加
                return false;
            }
        }

        // midF 就是要添加位置的父结点
        if (com > 0){
            // 最后一次比较, value大
            midF.right = new Node(value);
        }else {
            // 最后一次比较, value小
            midF.left = new Node(value);
        }
        size++;

        return true;
    }
    // 对二叉搜索树的删除方法: 在二叉搜索树种删除一个结点/值
    public boolean remove(T value) {
        // 不允许在二叉搜索树中存储null值, 因为null没办法比较大小
        if(value == null) throw  new IllegalArgumentException("parame is null");

        // 二叉搜索树不能是空树
        if (isEmpty()) throw new RuntimeException("tree is empty");

        // 查找要删除结点
        Node mid = root;// 遍历结点(用于查找要删除的结点)
        Node midF = null; // 遍历结点的父结点

        while (mid != null){
            int com = value.compareTo(mid.value);
            if (com == 0){
                // mid 就是要删除的元素
                break;
            }else if (com > 0){
                // value 比较大, 如果这个value存在在二叉搜索树, 应该在此时mid的right方向
                midF = mid;// 记录父结点位置
                mid = mid.right;// 子结点右转
            }else {
                // value 比较小, 如果这个value存在在二叉搜索树, 应该在此时mid的left方向
                midF = mid;// 记录父结点位置
                mid = mid.left;// 子结点左转
            }
        }


        // 上述循环有两个跳出条件
        // mid == null  --> 没有找到, 这个树上没有存储这个元素
        // 否则就是找到了

        if (mid == null)return false;

        // mid就是找到的要删除结点位置
        // midF 就是找到的要删除结点的父位置

        // 先处理删除双分支情况 --> 替换
        if (mid.left != null && mid.right != null){
            // mid 的left 和right 都是不是 null
            // mid 是一个双分支结点: 先替换再删除
            // 替换: (左子树最大值, 右子树最小值) 右子树的最小值
            Node min = mid.right;
            Node minF = mid;
            while (min.left != null){
                // mid 的left 还有结点, min不是最小, 接着想left移动找最小
                minF = min;
                min = min.left;
            }

            // min就是mid 的right子树最小值
            // minF 就是最小值的父结点

            // 替换值
            mid.value = min.value;

            // 把要删除结点的引用, 指向这个已经完成替换的结点
            mid = min;
            midF = minF;
        }

        // 再处理删除叶子或者单分支(双份支替换之后的叶子和单分支)

        // 拿到要删除结点的孩子
        // (如果是个单分支,拿到那个不为null的孩子)
        // (如果本来就是叶子, 拿到null)
        Node ch = mid.left != null? mid.left: mid.right;

        // TODO: 特殊情况: 如果这个树的根节点是个单分支, 而且要删除的结点也是这个根节点
        if (midF == null)  {
            root = ch;
            size-- ;
            return true;
        }

        if (midF.left == mid){
            // 删除的是midF 的left
            midF.left = ch;
        } else {
            // 删除的是midF 的right
            midF.right = ch;
        }

        size--;
        return true;
    }
    // 查找二叉搜索树中, 某个值是否存在
    public boolean contains(T value){
        // 不允许在二叉搜索树中存储null值, 因为null没办法比较大小
        if(value == null) throw  new IllegalArgumentException("parame is null");

        // 二叉搜索树是空, 意味着没有存储这个元素
        if (isEmpty()) return  false;

        // 二叉搜索树不空
        Node mid = root;// 定义一个遍历结点, 遍历
        while (mid != null){
            int com = value.compareTo(mid.value);

            if (com == 0){
                // mid就是要查找的值
                return true;
            }else if (com > 0){
                // value更大, 如果value在树中存在, 那么在mid的right
                mid = mid.right;
            }else {
                // value更小, 如果value在树中存在, 那么在mid的left
                mid = mid.left;
            }
        }
        // 没找到, mid == null
        return false;
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
    // 用栈实现中序遍历
    public List<T> inOrder() {
        MyArrayStack<Node> stack = new MyArrayStack<>();
        List<T> list = new ArrayList<>();

        // 定义一个标记结点
        Node mid = root;

        // 循环: 栈不为空 或者 标记结点不是null
        while (!stack.isEmpty()  || mid != null){
            // 小循环: mid left序列统统入栈
            while (mid != null){
                stack.push(mid);
                mid = mid.left;
            }
            // 出栈遍历
            Node pop = stack.pop();
            list.add(pop.value);

            // 标记结点指向出栈结点的right
            mid = pop.right;
        }

        return list;
    }

    public List<T> inOder2(){
        ArrayList<T> list = new ArrayList<>();
        inOder2(root, list);
        return list;
    }

    // 递归核心思想:  大问题转化成小问题
    // 不要上来就想出口是什么, 也不要一开始就想怎么触发这个递归
    // 问题的共性 --- 最重要,
    // 比如这个中序遍历, 如果给我一个结点,  遍历左子树, 遍历根 遍历右子树

    // 递归实现中序遍历
    private void inOder2(Node root, ArrayList<T> list) {
        // 出口:
        if (root == null) return;

        // 遍历左子树
        inOder2(root.left, list);
        // 遍历根
        list.add(root.value);
        // 遍历右子树
        inOder2(root.right, list);
    }


    // 后序: 栈, 递归
    // 用栈实现后序遍历
    public List<T> postOrder(){
        MyArrayStack<Node> stack = new MyArrayStack<>();
        List<T> list = new ArrayList<>();

        // 1, 根节点入栈
        stack.push(root);

        // 2, 循环, 栈不为空
        while (!stack.isEmpty()){
            Node pop = stack.pop();// 出栈元素
            list.add(0, pop.value);// 逆序遍历(头插法遍历)

            if (pop.left != null) stack.push(pop.left);
            if (pop.right != null) stack.push(pop.right);
        }

        return list;
    }

    public List<T> postOrder2(){
        ArrayList<T> list = new ArrayList<>();
        postOrder2(root, list);
        return list;
    }
    private void postOrder2(Node root, ArrayList<T> list) {
        // 出口:
        if (root == null) return;

        // 遍历左子树
        postOrder2(root.left, list);
        // 遍历右子树
        postOrder2(root.right, list);
        // 遍历根
        list.add(root.value);
    }

    // 层级遍历: 队列
    public List<T> leOrder(){
        MyArrayQueue<Node> queue = new MyArrayQueue<>();
        ArrayList<T> list = new ArrayList<>();

        // 根节点入队列
        queue.offer(root);

        // 循环: 队列不空
        while (!queue.isEmpty()){
            // 出队列一个元素遍历
            Node poll = queue.poll();
            list.add(poll.value);

            // 出队列结点的左右子结点入队列
            if (poll.left != null)queue.offer(poll.left);
            if (poll.right != null)queue.offer(poll.right);
        }

        return list;
    }


    // 建树操作: 前序+中序
    // 建树操作: 后序+中序
    public void buildTreeByPostAndInOrder(List<T> postOrder, List<T> inOrder){
        // 递归方法
        root = buildTreeByPostAndInOrder2(postOrder, inOrder);
        size = inOrder.size();
    }


    //后序: [-2, -1, 0, 1, 6, 7, 5, 13, 11, 20, 15, 10]
    //中序: [-2, -1, 0, 1, 5, 6, 7, 10, 11, 13, 15, 20]
    private Node buildTreeByPostAndInOrder2(List<T> postOrder, List<T> inOrder) {
        // 出口
        if (postOrder.size() == 0)return null;
        if (postOrder.size() == 1){
            return new Node(postOrder.get(0));
        }


        // 获得根节点的值, 后序的最后一个元素
        T rootValue = postOrder.get(postOrder.size() - 1);

        // 创建根节点
        Node node = new Node(rootValue);

        // 获取根节点在中序中的位置
        int index = inOrder.indexOf(rootValue);

        //后序: [-2, -1, 0, 1, 6, 7, 5, 13, 11, 20, 15, 10]  左 右  根
        //中序: [-2, -1, 0, 1, 5, 6, 7, 10, 11, 13, 15, 20]  左 根 右
        //                            index

        // 左子树left:
        //      中序: inOrder ->  0 - index-1
        //      后序: postOrder-> 0 - index-1

        // 右子树right:
        //      中序: inOrder ->  index+1 - size-1
        //      后序: postOrder-> index - size-2

        List<T> leftInOder  = inOrder.subList(0, index);
        List<T> leftPostOder  = postOrder.subList(0, index);

        List<T> rightInOder  = inOrder.subList(index+1, inOrder.size());
        List<T> rightPostOder  = postOrder.subList(index, inOrder.size() - 1);

        // 递归去构建node 的left子树和right子树
        node.left = buildTreeByPostAndInOrder2(leftPostOder, leftInOder);
        node.right = buildTreeByPostAndInOrder2(rightPostOder, rightInOder);


        return node;
    }


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
