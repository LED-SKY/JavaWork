package www.day4.stack;

public class Demo2 {
    public static void main(String[] args) {

        MyArrayStack<String> stack = new MyArrayStack<>(2);
        stack.push("zs");
        stack.push("ls");
        stack.push("wu");
        stack.push("zl");


        // zs  - ls  - wu   -zl
        // 栈底              栈顶
        // 0    1      2      3


        // zs  - ls  - wu   -zl
        // 栈底      栈顶
        // 0    1      2
        String pop = stack.pop();
        System.out.println(pop);

        System.out.println(stack);


        // zs  - ls  - wu   - aa
        // 栈底              栈顶
        // 0    1      2     3
        stack.push("aa");
        System.out.println(stack);

    }
}
