package www.day3.mydblinked;

/**
 *  手动实现一个集合( 类似于jdk提供的LinkedList)
 *   用双向链表实现
 *   模拟的数据结构是: 线性表
 */
public class MyDBLinked {

    private Node head;// 双向链表的头结点
    private Node end;// 双向链表的尾结点
    private int size;// 链表中存储的元素数量

    /**
     * 双向链表的添加方法
     * @param value : 要添加的值
     * @return : 添加是否成功
     */
    public boolean add(String value){
        if (value == null) throw new IllegalArgumentException("parame is null");

        if (isEmpty()){// 链表没有存储任何元素
            head = new Node(null, value, null);
            end = head;
            size++;
            return true;
        }


        // 链表中原本存储的有元素,
        // 把要添加的元素放到链表尾部
//        Node node = new Node(null, value, null);
//        node.pre = end;
//        end.next = node;
        end.next = new Node(end, value, null);// 把结点放到链表尾部
        end = end.next;// 尾结点后移
        size++;

        return true;
    }

    /**
     * 根据内容, 丛链表中删除某一个元素
     * @param value: 要删除的元素
     * @return: 删除是否成功
     */
    public boolean remove(String value){
        if (value == null) throw new IllegalArgumentException("parame is null");
        if (isEmpty()) throw new RuntimeException("linked is empty");

        // 链表不空
        if (value.equals(head.value)){// 判断删除的是否是头结点
            // 删除 的是头结点

            if (size == 1){// 如果删除的时候, 链表仅有一个结点
                head = null;
                end = null;
            }else {// 如果删除的时候, 有多个结点
                head = head.next;
                head.pre = null;
            }
            size--;
            return true;
        }

        // 如果删除的不是头结点, 遍历找到要删除的结点
        Node mid = head;
        // 如果后面还有结点可以遍历, 并且后面这个结点的内容不是要删除的内容
        // 向后遍历结点,
        while (mid.next != null && !mid.next.value.equals(value)){
            mid = mid.next;
        }

        // 上述循环两个跳出条件
        // 1, 没找到, mid.next == null
        // 2, 找到了, mid 就是找到结点的之前一个结点(父结点)

        if (mid.next == null) return false;

        // removeNode 就是要删除的结点
        Node removeNode = mid.next;

        if (removeNode == end){// 要删除的是尾结点
            end = end.pre;
            end.next = null;
        }else { // 要删除的是中间结点
            removeNode.next.pre = removeNode.pre;
            removeNode.pre.next = removeNode.next;
        }
        size--;

        return true;
    }


    /**
     * 根据下标添加一个元素
     * @param index : 下标
     * @param value: 添加的元素
     * @return: 添加是否成功
     */
    public boolean add(int index, String value){
        if (index < 0 || index > size)
            throw  new IllegalArgumentException("index = "+ index + "size = " + size);

        if (index <= size/2){// 偏前位置
            if (index == 0){// 添加的是一个头位置
                Node newNode = new Node(null, value, head);
                if (head == null){
                    head = newNode;
                    end = newNode;
                }else {
                    head.pre = newNode;
                    head = newNode;
                }
                size++;
                return true;
            }

            // 添加的不是头位置
            Node mid = head;
            int tag = 1;
            while (tag != index){
                mid = mid.next;
                tag++;
            }

            // mid 要添加位置之前的一个位置
            Node node = new Node(mid, value, mid.next);
            mid.next = node;
            node.next.pre = node;
            size++;
            return true;

        }else {// 更靠后

            // 按照下标遍历结点, 找到要添加位置
            Node mid = end;
            int tag = size;
            while (tag != index){
                tag--;
                mid = mid.pre;
            }

            // mid是要添加位置的之前一个结点
            if (mid == end){// 要添加一个尾结点
                mid.next = new Node(end, value, null);
                end = end.next;
            }else {// 添加的不是尾结点
                Node node = new Node(mid, value, mid.next);
                mid.next = node;
                node.next.pre = node;
            }
            size++;
            return true;
        }
    }


    /**
     * 根据下标删除下标对应内容
     * @param index: 要删除的下标位置
     * @return:  被删除的元素
     */
    public String remove(int index){
        if (index < 0 || index >= size) throw  new IllegalArgumentException("index = "+ index + ", size =" + size);

        if (index <= size/2){// 靠近链表头部
            if (index == 0){// 删除的是头结点
                String oldValue = head.value;
                if (size == 1){// 链表中仅剩一个元素
                    head = null;
                    end = null;
                }else {// 有多个元素
                    head = head.next;
                    head.pre = null;
                }
                size--;
                return oldValue;
            }
            // 删除的非头结点
            // 删除的下标 是index
            Node mid = head;
            int tag = 1;
            while (tag != index){
                tag++;
                mid = mid.next;
            }
            // 上述循环结束, mid就是要查找元素的前一个位置
            // 要删除的结点 mid.next
            Node removeNode = mid.next;
            removeNode.next.pre = removeNode.pre;
            removeNode.pre.next = removeNode.next;
            size--;
            return removeNode.value;

        }else {// 靠近链表尾部

            // 从后向前遍历
            Node mid = end;
            int tag = size;
            while (tag != index){
                mid = mid.pre;
                tag--;
            }

            // 遍历完成mid 是要查找结点的前一个结点
            Node removeNode = mid.next;

            if (removeNode == end){// 要删除的是尾结点
                end = end.pre;
                end.next = null;
            }else {// 删除的不是尾结点
                removeNode.next.pre = removeNode.pre;
                removeNode.pre.next = removeNode.next;
            }
            size--;
            return removeNode.value;
        }
    }





    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }

    class Node{
        String value;
        Node pre;
        Node next;

        public Node(Node pre, String value,  Node next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }
}
