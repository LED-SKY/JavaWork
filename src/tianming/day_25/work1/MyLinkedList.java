package tianming.day_25.work1;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.sun.xml.internal.ws.api.pipe.NextAction;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-07 15:40
 * <p>
 * 用单链表实现集合类
 **/
public class MyLinkedList {

    private Node head;
    private int size = 0;

    //判断集合类里是否有数据
    public boolean isEmpty() {
        return size == 0;
    }

    //获取集合类里的数据数量
    public int getSize() {
        return size;
    }

    //添加数据
    public boolean add(String str) {
        if (isEmpty()) {
            //如果添加数据的位置为头结点
            head = new Node(str, null);
            size++;
            return true;
        }
        //如果添加的位置不为头结点
        Node mid = head;
        while (mid.next != null) {
            mid = mid.next;
        }
        //遍历完到这里则表示已经是尾结点
        mid.next = new Node(str, null);
        size++;
        return true;
    }

    //删除数据
    public boolean Remove(String str) {

        //p判断链表是否为空
        if (isEmpty()) throw new RuntimeException("此集合类为空，无法删除数据");
        //链表不空
        if (str == null) {
            if (str == head.data) {
                //让头结点的引用指向头结点的下一个节点
                head = head.next;
                size--;
                return true;
            }

            //如果删除的不是头结点
            Node mid = head;
            while (mid.next != null && str != mid.next.data) {
                mid = mid.next;
            }
            //上面的循环结束是两种情况造成的
            //1.没有找到元素
            if (mid.next == null) return false;

            //2.找到了 元素,并且mid是找到的元素之前的一个节点
            mid.next = mid.next.next;
            size--;
        } else {
            if (str.equals(head.data)) {
                //让头结点的引用指向头结点的下一个节点
                head = head.next;
                size--;
                return true;
            }

            //如果删除的是尾结点
            Node mid = head;
            while (mid.next != null && !(str.equals(mid.next.data))) {
                mid = mid.next;
            }
            //上面的循环结束是两种情况造成的
            //1.没有找到元素
            if (mid.next == null) return false;

            //2.找到了 元素,并且mid是找到的元素之前的一个节点
            mid.next = mid.next.next;
            size--;
        }
        return true;
    }

    /**
     * 查找某个值, 在这个集合类中是否存储了
     *
     * @param value : 要查找的值
     * @return : 是否存储的有
     */
    public boolean contains(String value) {
        //判断查找的值是否为null
        if (value == null) {
            if (value == head.data) {
                return true;
            }
            Node mid = head;

            while (mid.next != null) {

                if (mid.next.data == value) {
                    return true;
                }
                mid = mid.next;
            }
            return false;
        } else {
            if (value.equals(head.data)) return true;
            Node mid = head;
            while (mid.next != null) {
                if (value.equals(mid.next.data)) return true;
                mid = mid.next;
            }
            return false;
        }


    }

    /**
     * 给这个集合类提供一个修改内部元素的方法
     *
     * @param oldValue : 要修改的元素
     * @param newValue : 新的值(用来替换的值)
     * @return : 修改是否成功
     */
    public boolean set(String oldValue, String newValue) {

        //判断要修改的值是否存在
        if (!contains(oldValue)) return false;

        //遍历链表
        Node mid = head;
        while (mid.next != null) {
            if (oldValue == null) {
                if (mid.data == oldValue) {
                    mid.data = newValue;
                }
                mid = mid.next;

            } else {
                if (mid.data.equals(oldValue)) {
                    mid.data = newValue;
                }
                mid = mid.next;
            }
        }
        return true;
    }
//.add(1, "zs");
//.remove(0);
//.get(0);
//.set(0, "zs");

    public boolean add(int index, String value) {
        //判断输入的下标是否在范围内
        if (index > (size - 1)) throw new NullPointerException("下标越界了");

        Node newNode = new Node(value, null);
        //当插入的节点为头结点时
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return true;
        }
        //用来做一个移动指针
        Node mid = head;
        for (int i = 1; i < index; i++) {

            mid = mid.next;
        }
        //循环出来后mid   移动到要插入的下标
        newNode.next = mid.next;
        mid.next = newNode;
        size++;
        return true;
    }

    public boolean remove(int index) {
        if (isEmpty()) throw new RuntimeException("集合类没有数据可以删除");

        if (index > (size - 1)) throw new NullPointerException("下标越界了");

        if (index == 0) {
            head = head.next;
            size--;
            return true;
        }
        Node mid = head;
        for (int i = 0; i < index - 1; i++) {
            mid = mid.next;
        }

        mid.next = mid.next.next;
        size--;
        return false;
    }

    public String get (int index){
        if (index > (size - 1)) throw new NullPointerException("下标越界了");

        Node mid = head;
        for (int i = 0; i < index; i++) {
            mid  =  mid.next;
        }
       //循环出来则表示已经定位到传过来的下标的节点
        return  mid.data;
    }
    
    public boolean set(int index,String value){
        if (index > (size - 1)) throw new NullPointerException("下标越界了");
        Node newNode = new Node(value,null);
        if (index ==  0){
            newNode.next = head;
            head = newNode;
            size++;
            return true;
        }
        newNode =  head;
        for (int i = 0; i < index; i++) {
            newNode = newNode.next;
        }
        //循环出来为输入的下标的节点位置
        newNode.data  =  value;
        return true;
    }
    
    class Node {
        String data;
        Node next;

        public Node() {
        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data='" + data + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }
}
