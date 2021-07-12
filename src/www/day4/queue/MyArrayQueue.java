package www.day4.queue;

public class MyArrayQueue<T> {

    private final  int MAX_CAPACITY = Integer.MAX_VALUE - 8;
    private final  int INIT_CAPACITY = 10;

    private Object[] arr;// 底层循环数组
    private int size;// 队列中存储了多少元素
    private int head;// 队头的下标
    private int end;// 队尾的下标

    public MyArrayQueue() {
       this.arr = new Object[INIT_CAPACITY];
    }
    public MyArrayQueue(int initCapacity) {
        if (initCapacity < 1 || initCapacity > MAX_CAPACITY)throw new IllegalArgumentException("initCapacity is Illegal");
        this.arr = new Object[initCapacity];
    }

    // offer  poll peek

    public boolean offer(T value){
        if (size == arr.length){
            // 底层数组满了, 需要扩容
            int newLen = getLen();
            grow(newLen);
        }

        // 走到这, 意味着数组中有位置可以添加
        if (size == 0){
            // 原本数组没有存储元素
            arr[head] = value;
            end = head;
        }else {
            // 原本数组已经存储元素
            end = (end + 1) % arr.length;
            arr[end] = value;
        }

        size++;
        return true;
    }
    private void grow(int newLen) {
        Object[] newArr = new Object[newLen];

        // 把旧数组的数组转移到新数组
        for (int i = 0; i < arr.length; i++) {
            int index = (head + i) % arr.length;
            newArr[i] = arr[index];
        }

        // 重新定义指向
        arr = newArr;
        head = 0;
        end = size -1;
    }
    private int getLen() {
        // 旧数组长度
        int oldLen = arr.length;

        // 新长度扩为原来的二倍
        int newLen = oldLen * 2;

        if (newLen >= MAX_CAPACITY || newLen < 0){
            newLen = MAX_CAPACITY;
        }

        if (newLen == oldLen)throw new RuntimeException("stack can not add");

        return newLen;
    }

    public T poll(){
        if (isEmpty()) throw new  RuntimeException("queue is empty");

        T vlaue  = (T)arr[head];

        if (size == 1){// 原本队列中只剩一个元素
            head = 0;
            end = 0;
        }else {
            // 队列中有多个元素
            head = (head + 1) % arr.length;
        }
        size--;
        return vlaue;
    }


    public T peek() {
        if (isEmpty()) throw new RuntimeException("queue is empty");

        return (T)arr[head];
    }

        public boolean isEmpty(){
        return size == 0;
    }

}
