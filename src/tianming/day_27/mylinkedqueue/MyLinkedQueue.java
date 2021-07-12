package tianming.day_27.mylinkedqueue;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-09 14:55
 * 
 * 模拟队列
 * 用单链表
 **/
public class MyLinkedQueue <T>{
    
    private Node head;//队列的队头
    private Node end;//队列的队尾
    private int size;//队列存储了多少元素
    //功能：入队，出队，查看对首  offer、poll、peek
    
    public boolean offer(T value){
        if (isEmpty()){
            //判断队列是否为空，为空的话，既是队头又是队尾
            head = new Node(value,null);
            end = head;
            size++;
            return true;
        }else {
            //不为空的话,添加在队尾
            Node newNode = new Node(value,null);
            end.next = newNode;
            //移动队尾指针
            end = newNode;
            size++;
            return true;
        }
    }
    
    //出队
    public T poll(){
        if (isEmpty()) throw new RuntimeException("queue is empty");
        //出队的值
        T value = head.value;
        if (size == 1){ //队列只有一个元素时
            head = null;
            end = null;
            size--;
            return value;
        }else { //队列不止一个元素时
            head = head.next;
            size--;
            return value;
        }
    }
    //查看队尾
    public T peek(){
        if (isEmpty()) throw new RuntimeException("queue is empty");
        T value = end.value;
        return value;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    public int getSize(){
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

