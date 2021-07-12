package tianming.day_27.mylinkedqueue;

/**
 * @program: Stage1
 * @description: 数组实现队列
 * @author: 邓造坚
 * @create: 2021-07-09 15:47
 **/

//使用循环数组来进行实现
public class MyArrayQueue<T> {
    //数组可扩容的最大长度，需要8bytes的存储大小存储数组的元数据所以需要-8
    //数组元数据：Class，Flag，Lock，Size
    private final int MAX_CAPACITY = Integer.MAX_VALUE - 8;
    private final int INIT_CAPACITY = 10;//数组的默认容量
    private Object[] arr;//这个集合类底层循环数组
    private int head;//队头的下标
    private int end;//队尾的下标
    private int size;//这个集合类所存储的元素个数

    public MyArrayQueue() {
        this.arr = new Object[INIT_CAPACITY];
    }

    public MyArrayQueue(int initCapacity) {
        if (initCapacity < 1 || initCapacity > MAX_CAPACITY) throw new IllegalArgumentException("不可定义此数组长度");
        this.arr = new Object[initCapacity];
    }

    public boolean offer(T value) {
        if (size == arr.length) {
            //需要进行扩容
            //首先将长度进行扩容
            int newLen = getLen();
            //再将旧数组赋值给新数组
            grow(newLen);
        }
        if (size == 0) {//数组中没数据
            arr[size] = value;
            head = 0;
            end = head;

        } else {//数组中有数据
            end = (end + 1) % arr.length;
            arr[end] = value;
        }
        size++;
        return true;
    }

    //出栈
    public T poll() {
        if (isEmpty()) throw new RuntimeException("队列中没有数据");
        T value = (T) arr[head];
        if (size == 1) { //队列只有一个数据
            head = 0;
            end = 0;
        } else { //队列有多个数据
            head = (head + 1) % arr.length;
            
        }
        size--;
        return value;
    }

    //查看队首元素
    public T peek(){
        if (isEmpty())throw new RuntimeException("队列为空");
        return (T) arr[head];
        
    }
    //对长度进行扩容
    private int getLen() {
        int oldLen = arr.length;
        //扩容为旧长度的两倍
        int newLen = oldLen * 2;
        //如果扩容后的长度溢出，就把newLen设置为MAX_CAPACITY
        if (newLen >= MAX_CAPACITY || newLen < 0) {
            newLen = MAX_CAPACITY;
        }
        //如果当扩容后的长度等于就长度的话，即都为MAX_CAPACITY，则表示无法扩容
        if (newLen == oldLen) throw new RuntimeException("stack is not add");
        return newLen;
    }

    //将旧数组一一复制掉新数组中
    private void grow(int newLen) {
        //新数组
        Object[] newArr = new Object[newLen];
        //转移数据
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        //改变引用
        arr = newArr;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

}
