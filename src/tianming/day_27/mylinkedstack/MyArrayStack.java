package tianming.day_27.mylinkedstack;

import java.util.BitSet;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-09 10:43
 * <p>
 * 模拟实现栈
 * 底层结构：数组
 **/
public class MyArrayStack<T> {

    //数组可扩容的最大长度，需要8bytes的存储大小存储数组的元数据所以需要-8
    //数组元数据：Class，Flag，Lock，Size
    private final int MAX_CAPACITY = Integer.MAX_VALUE - 8;
    private final int INIT_CAPACITY = 10;//数组的默认容量
    private Object[] objs;//这个集合类底层所持有的数组
    private int size;//这个集合类所存储的元素个数

    public MyArrayStack() {
        objs = new Object[INIT_CAPACITY];
    }

    public MyArrayStack(int initCapacity) {
        if (initCapacity < 1 || initCapacity > MAX_CAPACITY) throw new IllegalArgumentException("无法存下");
        objs = new Object[initCapacity];
    }

    //入栈
    public boolean push(T value) {
        //添加的时候，先判断底层数组是否满了
        if (size == objs.length) {
            //表示数组满了。需要扩容
            int newLen = getLen();  //获取扩容的长度
            grow(newLen);   //根据要扩容的长度，扩容这个数组
        }

        //到这一步意味着数组一定有位置可供添加数据
        objs[size] = value;
        size++;
        return true;
    }

    //将扩容后的新数组赋给旧数组
    private void grow(int newLen) {
        Object[] newObjs = new Object[newLen];

        //把旧数组的数据转移到新数组
        for (int i = 0; i < objs.length; i++) {
            newObjs[i] = objs[i];
        }
        //把新数组的引用赋给底层数组
        objs = newObjs;
    }

    //获取一个数组的新长度
    private int getLen() {
        //旧数组长度
        int oldLen = objs.length;

        //新长度为扩容的两倍
        int newLen = oldLen * 2;
        
        //不足以扩大两倍所以只能扩大到最大值MAX_CAPACITY
        if (newLen >= MAX_CAPACITY || newLen < 0){
            newLen = MAX_CAPACITY;
        }
        //表示oldLen本来就是最大值，已经无法进行扩容
        if (newLen == oldLen)throw new RuntimeException("stack can not add");
        return newLen;
    }

    //出栈
    public T pop() {
        if (isEmpty()) throw new RuntimeException("stack is empty");
        //数组的最后元素的下标为：size - 1
        T value = ((T) objs[size - 1]);
        //可以设置objs[size - 1]) = null 也可以不设置，因为后面再入栈元素的时候会覆盖掉
        size--;
        return value;
    }

    //输出栈顶的元素
    public T peek() {
        if (isEmpty()) throw new RuntimeException("stack is empty");
        return (T) objs[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}
