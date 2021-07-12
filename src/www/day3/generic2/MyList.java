package www.day3.generic2;

public class MyList<T> {


    private Node head;// 链表的头结点
    private int size;// 这个集合类中存储了多少元素

    public boolean add(T value) {
        if (value == null) throw new IllegalArgumentException("parame is null");
        if (size == 0){
            head = new Node(value, null);
            size++;
            return true;
        }
        Node mid = head;
        while (mid.next != null){
            mid = mid.next;
        }
        mid.next = new Node(value, null);
        size++;
        return true;
    }

    public T get(int index){
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

    class Node{
        T value;
        Node next;
        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

    }



}
