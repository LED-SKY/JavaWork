package tianming.day_27.Work1;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-09 20:15
 * <p>
 * 底层是数组的线性表
 **/
public class MyListArray<T> {

    private final int MAX_CAPACITY = Integer.MAX_VALUE - 8;
    private Object[] arr;
    private int size;

    public MyListArray() {
        arr = new Object[10];
    }

    public MyListArray(int initCapacity) {
        if (initCapacity < 1 || initCapacity > MAX_CAPACITY)
            throw new IllegalArgumentException("initCapacity = " + initCapacity);
        arr = new Object[initCapacity];
    }

    // 增
    public boolean add(T t) {
        if (t == null) throw new IllegalArgumentException("parame is null");
        if (arr.length == size) {
            int newLen = getLen();
            grow(newLen);
        }
        arr[size++] = t;
        return true;
    }

    private void grow(int newLen) {
        Object[] objs = new Object[newLen];
        for (int i = 0; i < arr.length; i++) {
            objs[i] = arr[i];
        }
        arr = objs;
    }

    private int getLen() {
        int oldLen = arr.length;
        int newLen = (oldLen * 2);
        if (newLen < 0 || newLen > MAX_CAPACITY) {
            newLen = MAX_CAPACITY;
        }
        if (oldLen == newLen) throw new RuntimeException("stack is full");
        return newLen;
    }

    public boolean remove(T t) {
        if (t == null) throw new RuntimeException("不允许输入null");
        if (isEmpty()) throw new RuntimeException("线性表为空，没有可以删除的数据");
        //数组只有一个元素的时候
        if ((size == 1) && t.equals(arr[0])) {
            arr[0] = null;
        } else {
            //记录找到要删除的元素的下标
            int num = -1;
            for (int i = 0; i < size; i++) {
                if (t.equals(arr[i])) {
                    num = i;
                    break;
                }
            }
            //没找到要删除的元素
            if (num == -1) return false;
            //将下标之后的元素都向前移动一位

            for (int i = num; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }

        }
        size--;
        return true;
    }

    //查找数据是否存在
    public boolean contains(T t) {
        if (t == null) throw new RuntimeException("不允许输入null");
        if (isEmpty()) throw new RuntimeException("线性表为空，没有可以查找的数据");

        for (int i = 0; i < size; i++) {
            if (t.equals(arr[i])) return true;
        }
        return false;
    }

    //找到数据并修改数据
    public boolean set(T oldT, T newT) {
        if (oldT == null || newT == null) throw new RuntimeException("不允许输入null");
        if (isEmpty()) throw new RuntimeException("线性表为空，没有可以修改的数据");

        for (int i = 0; i < size; i++) {
            if (oldT.equals(arr[i])) {
                arr[i] = newT;
                return true;
            }
        }
        return false;
    }

    // 根据下标添加
    public boolean addData(int index, T t) {
        if (index < 0 || index > size) throw new RuntimeException("输入的下标越界了");
        if (t == null) throw new RuntimeException("不允许输入null");
        if (arr.length == size) {
            int newLen = getLen();
            grow(newLen);
        }
        //将后面的元素都向后移一位
        for (int i = size + 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        //往腾出的下标为0的数组中添加元素
        arr[index] = t;

        size++;
        return true;

    }

    // 根据下标删除
    public T removeData(int index) {
        if (index < 0 || index > size - 1) throw new RuntimeException("输入的下标越界了");
        if (isEmpty()) throw new RuntimeException("线性表为空，无法删除数据");
        T value = (T) arr[index];
        for (int i = index; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return value;
    }

    // 根据下标查找
    public T getData(int index) {
        if (index < 0 || index > size - 1) throw new RuntimeException("输入的下标越界了");
        if (isEmpty()) throw new RuntimeException("线性表为空，无法查找数据");
        return (T) arr[index];

    }

    // 根据下标替换
    public T setData(int index, T newValue) {
        if (index < 0 || index > size - 1) throw new RuntimeException("输入的下标越界了");
        if (isEmpty()) throw new RuntimeException("线性表为空，无法修改数据");
        if (newValue == null) throw new RuntimeException("不能输入null");
        T value = (T) arr[index];
        arr[index] = newValue;
        return value;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}