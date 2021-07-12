package tianming.day_27.mylinkedstack;

/**
 * @program: Stage1
 * @description: 单链表实现栈的测试类
 * @author: 邓造坚
 * @create: 2021-07-09 10:17
 **/
public class Demo {
    public static void main(String[] args) {
        MyLinkedStack<Object> stack = new MyLinkedStack<>();
        stack.push("zs");
        stack.push("ls");
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.peek());
    }
}
