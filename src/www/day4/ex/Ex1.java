package www.day4.ex;

import com.cskaoyan.www.day4.stack.MyArrayStack;

public class Ex1 {
    public static void main(String[] args) {


        String str = "123456789";
        String reStr = reStr(str);
        System.out.println(reStr);

    }

    private static String reStr(String str) {
        MyArrayStack<Character> stack = new MyArrayStack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        StringBuffer buffer = new StringBuffer();

        // 栈不空, 则出栈元素, 拼接新的字符串
        while (!stack.isEmpty()){
            Character pop = stack.pop();
            buffer.append(pop);
        }

        return buffer.toString();
    }
}
