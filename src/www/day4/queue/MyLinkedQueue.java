package www.day4.queue;

/**
 * 实现一个集合类
 * 模拟的数据结构是队列
 * 底层结构是: 单链表
 */
public class MyLinkedQueue<T> {

    private Node head;// 队列的队头
    private Node end;// 队列的队尾
    private int size;// 队列存储了多少元素

    // 作为队列, 它应该存在哪些操作?
    // 入队列-> 添加    出队列 -> 删除     查看队头元素 --> 查找
    //  offer            poll                   peek

    public boolean offer(T value){

        if (isEmpty()){
            // 原队列为空, 这个新添加的元素, 既是队头又是队尾
            head = new Node(value, null );
            end = head;
            size++;
            return true;
        }else {
            // 原队列不空, 这个新添加的元素, 放在队尾
            Node newNode = new Node(value, null);
            end.next = newNode;
            end = newNode;
            size++;
            return true;
        }
    }

    public T poll(){
        if (isEmpty())throw new RuntimeException("queue is empty");

        // 链表不空
        T value = head.value;

        if (size == 1){
            // 队列中只剩一个元素
            head = null;
            end = null;
        }else {
            // 队列中多于一个元素
            head = head.next;
        }
        size--;
       return value;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("queue is empty");
        return head.value;
    }


    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }

    class Node{
        T value;
        Node next;
        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
