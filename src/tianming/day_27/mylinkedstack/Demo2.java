package tianming.day_27.mylinkedstack;

/**
 * @program: Stage1
 * @description: 用数组实现的栈底层的测试类
 * @author: 邓造坚
 * @create: 2021-07-09 11:31
 **/
public class Demo2 {
    public static void main(String[] args) {
        MyArrayStack<Object> stack = new MyArrayStack<>(2);
        stack.push("zs");
        stack.push("ls");
        stack.push(1);
        stack.push("wu");
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.getSize());
        System.out.println(stack.peek());


    }
}
