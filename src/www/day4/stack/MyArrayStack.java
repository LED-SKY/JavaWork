package www.day4.stack;

import java.util.HashMap;

/**
 * 实现集合类
 * 模拟的数据结构是栈
 * 底层结构是数组
 */
public class MyArrayStack<T> {
    private final int MAX_CAPACITY = Integer.MAX_VALUE - 8;
    private final  int INIT_CAPACITY = 10;// 数组的默认容量

    private Object[] objs;// 这个集合类底层持有的数组
    private int size;// 这个集合类存储的元素数量

    public MyArrayStack(){
         objs = new Object[INIT_CAPACITY];
    }
    public MyArrayStack(int initCapacity){
        if (initCapacity < 1 || initCapacity > MAX_CAPACITY)throw new IllegalArgumentException("parame is Illegal");
        objs = new Object[initCapacity];
    }

    public boolean push(T value){
        // 在添加的时候, 要先判断底层数组是否满了
        if (size == objs.length){
            // 数组满了--> 扩容
            int newLen  = getLen();// 获取扩容的长度
            grow(newLen);// 根据要扩容的长度, 扩容这个数组
        }

        // 到这一步, 意味着, 数组一定有位置可供添加数据

        // 添加元素, 栈顶在size-1位置,   栈底在下标为0的位置
        objs[size] = value;
        size++;

        return true;
    }
    // 根据一个新长度扩容底层数组
    private void grow(int newLen) {
        Object[] newObjs = new Object[newLen];

        // 把旧数组的数据转移到新数组
        for (int i = 0; i < objs.length; i++) {
            newObjs[i] = objs[i];
        }

        objs = newObjs;
    }
    // 获取一个数组的新长度
    private int getLen() {
        // 旧数组长度
        int oldLen = objs.length;

        // 新长度扩为原来的二倍
        int newLen = oldLen * 2;

        if (newLen >= MAX_CAPACITY || newLen < 0){
            newLen = MAX_CAPACITY;
        }

        if (newLen == oldLen)throw new RuntimeException("stack can not add");

        return newLen;
    }

    // 栈的出栈方法
    public T pop(){
        if (isEmpty()) throw new RuntimeException("stack is empty");

        T value = (T)objs[size - 1];
        size--;

        return value;
    }

    // 栈的查看栈顶元素方法
    public  T peek(){
        if (isEmpty()) throw new RuntimeException("stack is empty");

        return  (T) objs[size - 1];
    }


    public boolean isEmpty(){
        return size == 0;
    }
    public int  size(){
        return size;
    }

}
