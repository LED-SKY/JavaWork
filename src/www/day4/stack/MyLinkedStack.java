package www.day4.stack;

/**
 * 实现集合类
 * 模拟的数据结构是栈
 * 底层结构是链表: 单链表
 */
public class MyLinkedStack<T> {

    private Node top;// 保存栈的栈顶
    private int size;// 这个栈中保存了多少个元素


    // 对于栈我们应该提供的三个方法:  入栈, 出栈, 查看栈顶元素
    //                              push    pop    peek

    /**
     * 给栈实现一个添加方法
     * @param value : 要添加的元素
     * @return : 添加是否成功
     */
    public boolean push(T value){
        top = new Node(value, top);
        size++;
        return true;
    }

    /**
     * 栈的删除操作
     * @return : 被删除的栈顶元素
     */
    public T pop(){
        // 判断链表为空
        if (isEmpty()) throw new RuntimeException("stack is empty");

        T value = top.value;// 保存原本栈顶值
        top = top.next; // 栈顶向栈底移动一个元素
        size--;

        return value;
    }

    /**
     * 栈的查看栈顶元素的方法
     * @return:  栈顶元素
     */
    public T peek(){
        // 判断链表为空
        if (isEmpty()) throw new RuntimeException("stack is empty");

        return top.value;
    }

    public  boolean isEmpty(){
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
