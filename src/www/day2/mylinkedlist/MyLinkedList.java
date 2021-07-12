package www.day2.mylinkedlist;

/**
 *  手动实现一个结合类( 类似于jdk提供的LinkedList)
 *   用单链表实现
 *   模拟的数据结构是: 线性表
 */
public class MyLinkedList {

    private Node head;// 链表的头结点
    private int size;// 这个集合类中存储了多少元素


    /**
     * MyLinkedList 这个集合类的添加方法
     * @param value : 添加的元素
     * @return: 添加是否成功
     */
    public boolean add(String value) {
        // 不允许存储null
        if (value == null) throw new IllegalArgumentException("parame is null");

        // 如果原本的链表为空---> 没有存储任何元素
        if (size == 0){// 这个集合类的底层数组, 没有任何元素
            // 新添加的元素就是头结点
            head = new Node(value, null);
            size++;
            return true;
        }

        // 走到这一步: 原链表不空
        // 把元素添加到尾部

        // 定义一个mid, 遍历这个单链表, 找到尾结点
        Node mid = head;
        while (mid.next != null){
            mid = mid.next;
        }

        // 上述循环结束意味着 mid是一个尾结点
        mid.next = new Node(value, null);
        size++;

        return true;
    }

    /**
     *  MyLinkedList 这个集合类的删除方法
     * @param str: 要删除的值
     * @return: 删除是否成功
     */
    public boolean remove(String str){
        // 链表是否为空
        if (isEmpty())throw new RuntimeException("linked is empty");

        // 判断删除的元素是不是null
        if (str == null){
            // 链表不空
            // 判断删除的是否为头结点
            if (str == head.value){
                // 删除的是头结点
                head = head.next;
                size--;
                return true;
            }

            // 不是头结点, 遍历链表, 查找要删除的结点
            Node mid = head;
            while (mid.next != null && !(str == mid.next.value)){
                mid = mid.next;
            }

            // 上述循环有两种跳出条件
            // 1. 没有找到这个要删除的元素:  mid.next == null
            // 2, 找到了, str.equals(mid.next.value)

            if (mid.next == null){
                // 没有找到要删除元素
                return false;
            }

            // 找到了, 并且mid是找到的要删除元素的之前一个结点
            mid.next = mid.next.next;
            size--;
        }else {
            // 链表不空
            // 判断删除的是否为头结点
            if (str.equals(head.value)){
                // 删除的是头结点
                head = head.next;
                size--;
                return true;
            }

            // 不是头结点, 遍历链表, 查找要删除的结点
            Node mid = head;
            while (mid.next != null && !str.equals(mid.next.value)){
                mid = mid.next;
            }

            // 上述循环有两种跳出条件
            // 1. 没有找到这个要删除的元素:  mid.next == null
            // 2, 找到了, str.equals(mid.next.value)

            if (mid.next == null){
                // 没有找到要删除元素
                return false;
            }

            // 找到了, 并且mid是找到的要删除元素的之前一个结点
            mid.next = mid.next.next;
            size--;
        }

        return true;
    }

    /**
     * 查找某个值, 在这个集合类中是否存储了
     * @param value : 要查找的值
     * @return : 是否存储的有
     */
    public boolean contains(String value){
        if (value == null) throw new IllegalArgumentException("parame is null");

        // 判断链表是否为空(该集合类是否存储元素)
        if (isEmpty()) throw new RuntimeException("linked is empty");

        Node mid = head;

        // 如果遍历的结点存在, 并且这个遍历结点存储的值不是要查找的值
        // 结点向后遍历
        while (mid != null && !mid.value.equals(value)){
            mid = mid.next;
        }
        // 上述两种跳出条件
        // 1, 没找到, mid == null
        if (mid == null) return false;

        // 2, 找到了

        return true;
    }

    /**
     * 给这个集合类提供一个修改内部元素的方法
     * @param oldValue : 要修改的元素
     * @param newValue : 新的值(用来替换的值)
     * @return : 修改是否成功
     */
    public boolean set(String oldValue, String newValue){
        // 不允许存储null
        if (oldValue == null || newValue == null) throw new IllegalArgumentException("parame is null");
        // 判断链表是否为空(该集合类是否存储元素)
        if (isEmpty()) throw new RuntimeException("linked is empty");


        // 查找旧值(oldValue)所在的结点
        Node mid = head;
        // 如果遍历的结点存在, 并且这个遍历结点存储的值不是要查找的值
        // 结点向后遍历
        while (mid != null && !mid.value.equals(oldValue)){
            mid = mid.next;
        }

        // 上述两种跳出条件
        // 1, 没找到, mid == null
        if (mid == null) return false;

        // 2, 找到了, 替换值
        mid.value = newValue;

        return true;
    }


    /**
     *  根据下标位置添加元素
     * @param index : 下标位置
     * @param value : 要添加的元素
     * @return : 添加是否成功
     */
    public boolean add(int index, String value){
        if (index < 0 || index > size) throw  new IllegalArgumentException("index is Illegal");

        if (isEmpty()){// 此时此刻链表为空
            head = new Node(value, null);
            size++;
            return true;
        }

        // 链表不空
        if (index == 0){// 链表不空, 并且新元素要添加到头位置
           head = new Node(value, head);
           size++;
           return true;
        }

        // 如果添加的不是头位置
        Node mid = head;
        int tag = 1;
        while (tag != index){
            tag++;
            mid = mid.next;
        }

        // 上述循环遍历完成, mid就是要添加位置之前的一个位置
        mid.next = new Node(value, mid.next);
        size++;

        return true;
    }


    /**
     * 根据下标在单链表上的删除
     * @param index: 要删除的位置
     * @return : 被删除的元素
     */
    public String remove(int index){
        if (index < 0 || index >= size) throw  new IllegalArgumentException("index is Illegal");

        // 这个地方不需要处理, 链表为空的情况(链表为空上述判断已经抛出异常)

        // 链表不空

        // 删除的是不是头结点
        if (index == 0){// 删除的是头结点
            String oldValue = head.value;
            head = head.next;
            size--;
            return oldValue;
        }

        // 删除的不是头结点

        // 找到要删除结点的之前的一个结点(要删除结点父结点)
        Node mid = head;
        int tag = 1;
        while (tag != index){
            mid = mid.next;
            tag++;
        }
        // mid 是要删除位置之前一个结点
        String oldValue = mid.next.value;

        mid.next = mid.next.next;
        size--;

        return oldValue;
    }

    /**
     * 根据下标获取下标地址存储的内容
     * @param index: 下标
     * @return : 下标位置存储的内容
     */
    public String get(int index){
        if (index < 0 || index >= size) throw  new IllegalArgumentException("index is Illegal");

        // 根据下标遍历结点
        Node mid = head;
        int tag = 0;
        while (tag != index){
            mid = mid.next;
            tag++;
        }

        // mid 就是要查找的下标结点

        return mid.value;
    }

    /**
     *  对单链表, 根据下标修改成新值
     * @param index : 要修改的位置
     * @param newValue: 要替换的新值
     * @return: 被替换的旧值
     */
    public String set(int index, String newValue){
        if (index < 0 || index >= size) throw  new IllegalArgumentException("index is Illegal");

        // 找到被替换的结点(遍历)
        // 根据下标遍历结点
        Node mid = head;
        int tag = 0;
        while (tag != index){
            mid = mid.next;
            tag++;
        }

        // mid 就是要替换的结点
        String oldValue = mid.value;// 保存旧值
        mid.value = newValue;// 给这位置替换新值

        return oldValue;
    }



    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return  size == 0;
    }

    public int size(){
        return size;
    }

    // 是个单链表结点
    class Node{
        String value;
        Node next;
        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

    }

}
