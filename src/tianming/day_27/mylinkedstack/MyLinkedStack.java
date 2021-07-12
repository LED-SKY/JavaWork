package tianming.day_27.mylinkedstack;

import java.time.temporal.ValueRange;

/**
 * @program: Stage1
 * @description: 模拟实现栈
 * @author: 邓造坚
 * @create: 2021-07-09 09:56
 * 
 * 底层结构：单链表
 **/
public class MyLinkedStack<T>{
    private Node top;//保存栈顶
    private int size;//这个栈保存的元素个数
    
    //提供三个方法：入栈、出栈、查看栈顶元素       push  pop  peek

    /**
     * 入栈操作
     * @param value：要添加的元素
     * @return :返回是否添加成功
     */
    
    public boolean push(T value){
         
       top =  new Node(value,top);
        size++;
        
        return true;
    }

    /**
     * 出栈操作
     * @return :被删除的栈顶元素
     */
    public T pop(){
        //判断链表是否为空
        if (isEmpty())throw new RuntimeException("栈为空，无法添加");
        //保存原本栈顶的值
        T value = top.value;
        //top指向后移，指向栈顶的下一个元素
        top = top.next;
        size--;
        return value;
    }
    
    public T peek(){
        return top.value;
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

        public Node() {
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
