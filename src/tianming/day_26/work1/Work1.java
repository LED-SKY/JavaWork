package tianming.day_26.work1;

import java.io.BufferedWriter;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-08 20:05
 * <p>
 * 双向链表，实现线性表
 **/
public class Work1 {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("zs");
        list.add("ls");
        list.add("wu");
        list.add("zl");
        System.out.println(list);
//        list.remove("zl");
//        list.set("wu", "aa");
//        System.out.println(list.get("wu"));
//        list.add(4, "aa");
//        list.remove(3);
//        String s = list.get(4);
//        System.out.println(s);
        list.set(3,"aa");
        System.out.println(list)
        ;


    }
}

class MyLinkedList {
    //头结点
    private Node head;
    //尾结点 
    private Node end;
    //集合类中的数据个数
    private int size = 0;

    //add  根据内容添加
    public boolean add(String value) {
        if (value == null) throw new RuntimeException("不能添加nulld值到集合类里");

        //集合类为空
        if (isEmpty()) { //直接添加到头节点
            head = new Node(null, value, null);
            end = head;
            size++;
            return true;
        } else { //添加到链表尾部
            end.next = new Node(end, value, null);  //将新节点连接到旧尾结点的后面
            end = end.next;   //将尾结点指针后移
            size++;
            return true;
        }
    }

    //remove    根据内容删除
    public boolean remove(String value) {
        //集合类为空时
        if (isEmpty()) throw new RuntimeException("集合类为空，不能删除数据");
        if (value == null) throw new RuntimeException("不允许输入null");

        //删除的地方是头结点
        if (value.equals(head.data)) {
            if (size == 1) {    //集合类只有一个结点
                head = null;
                end = null;
            } else {     //集合类不止一个结点
                head = head.next;
                head.pre = null;
            }
            size--;
            return true;
        }
        Node mid = head;
        while (mid.next != null && !value.equals(mid.next.data)) {
            mid = mid.next;
        }
        //循环出来mid是要删除结点的前一个结点
        //1.没找到要删除的数据所在的结点了
        if (mid.next == null) return false;
        //2.找到了

        //要删除结点的位置
        Node removeNode = mid.next;
        if (removeNode == end) {    //在尾结点
            mid.next = null;
            end = mid;
        } else {        //不在尾结点
            mid.next = removeNode.next;
            removeNode.next.pre = mid;
        }
        size--;
        return true;
    }

    //get   根据内容查找是否存在
    public boolean get(String value) {
        if (value == null) throw new RuntimeException("不能输入null");
        if (isEmpty()) throw new RuntimeException("集合类内没有内容");

        //判断查找的内容是否在头结点
        if (value.equals(head.data)) return true;

        Node mid = head;
        while (mid.next != null && !value.equals(mid.next.data)) {
            mid = mid.next;
        }
        //循环出来mid 为匹配到的结点的前一个结点的位置
        //1.没有找到
        if (mid.next == null) return false;

        //找到了

        return true;
    }

    //set   根据内容替换
    public boolean set(String oldValue, String newValue) {
        if (oldValue == null) throw new RuntimeException("输入值不允许为null");
        if (isEmpty()) throw new RuntimeException("集合类为空");

        //如果在头结点处
        if (oldValue.equals(head.data)) {
            head.data = newValue;
            return true;
        }

        Node mid = head;
        while (mid.next != null && !oldValue.equals(mid.next.data)) {
            //移动mid 执行下一个结点
            mid = mid.next;
        }
        //循环出来有两种情况
        //1.没有找到
        if (mid.next == null) return false;
        //2.找到了，循环出来的mid 指向的是匹配到的结点的前一个结点处
        mid.next.data = newValue;
        return true;
    }

    //.add(1, "zs");    根据下标添加
    public boolean add(int index, String value) {
        if (index < 0 || index > size) throw new RuntimeException("输入的index无效");
        if (value == null) throw new RuntimeException("不允许输入null");

        //添加位置为头结点
        if (index == 0) {
            Node newNode = new Node(null, value, head);
            head.pre = newNode;
            head = newNode;
            if (size == 0) {
                end = head;
            }
            size++;
            return true;
        }

        Node mid = head;
        //添加位置不为头结点
        for (int i = 1; i < index; i++) {
            mid = mid.next;
        }
        //循环出来后的mid是要插入的结点的前一个结点
        Node newNode = new Node(mid, value, mid.next);
        mid.next = newNode;
        newNode.pre = newNode;
        //判断是否为尾结点之后添加
        if (index == size) {
            end = newNode;
        }
        size++;
        return true;
    }

    //.remove(0);       根据下标删除
    public boolean remove(int index) {
        if (index < 0 || index > size - 1) throw new RuntimeException("输入的index不存在");
        if (isEmpty()) throw new RuntimeException("集合类为空，无法删除数据");

        //删除的为头结点时
        if (index == 0) {
            head = head.next;
            head.pre = null;
            size--;
            return true;
        }

        Node mid = head;
        Node removeNode = head.next;
        for (int i = 1; i < index; i++) {
            removeNode = removeNode.next;
            mid = mid.next;
        }
        //循环出来mid为要删除结点的前一个结点,removeNode为要删除的结点位置
        if (removeNode.next == null) {//删除的为尾结点
            mid.next = null;
            end = mid;
        } else {
            mid.next = removeNode.next;
            removeNode.next.pre = mid;
        }
        size--;
        return true;
    }

    //.get(0);          根据下标查找数据
    
    public String get(int index){
        if (index < 0|| index > size-1)throw new RuntimeException("输入的index不存在");
        if (isEmpty())throw new RuntimeException("集合表为空无法查询");
        
        
        Node mid =  head;
        for (int i = 0; i < index; i++) {
            mid = mid.next;
        }
        //循环出来的mid为要查找的下标的结点
        
        return mid.data;
    }
    //.set(0, "zs");    根据下标替换
    public boolean set (int index,String value){
        if (index < 0|| index > size-1)throw new RuntimeException("输入的index不存在");
        if (isEmpty())throw new RuntimeException("集合表为空无法查询");

        Node mid =head;
        for (int i = 0; i < index; i++) {
           mid = mid.next; 
        }
        //循环出来的mid为要找的下标的结点
       
        mid.data = value;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    //节点类
    class Node {

        //节点前指针
        Node pre;
        //数据
        String data;
        //节点后指针
        Node next;

        public Node() {
        }

        public Node(Node pre, String data, Node next) {
            this.pre = pre;
            this.data = data;
            this.next = next;
        }
    }
}