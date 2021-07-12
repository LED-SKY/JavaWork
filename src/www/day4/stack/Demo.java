package www.day4.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Demo {
    public static void main(String[] args) {

//        Stack<String> stack = new Stack<>();
//        stack.push("zs");
//        LinkedList<String> stack = new LinkedList<>();
//        stack.push("zs");


        MyLinkedStack<String> stack = new MyLinkedStack<>();
        stack.push("zs");
        stack.push("ls");
        stack.push("wu");
        stack.push("zl");

        // zs  ls  wu  zl
        // 栈底         栈顶

        String pop1 = stack.pop();
        String pop2 = stack.pop();

        System.out.println(pop1);
        System.out.println(pop2);

        System.out.println(stack.peek());




    }
}
