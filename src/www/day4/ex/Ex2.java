package www.day4.ex;

import com.cskaoyan.www.day4.stack.MyArrayStack;

public class Ex2 {
    public static void main(String[] args) {


        String str = "public class Ex2 { public static void main(String[] args) { } }";

        boolean bool = judgeBracket(str);

        System.out.println(bool);
    }

    private static boolean judgeBracket(String str) {
        MyArrayStack<Character> stack = new MyArrayStack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '{' ) stack.push('}');
            if (c == '(' ) stack.push(')');
            if (c == '[' ) stack.push(']');

            if (c == ')' || c == ']' || c == '}'){
                if (stack.isEmpty()) return false;
                Character pop = stack.pop();
                if (!pop.equals(c))return false;
            }
        }


        return stack.isEmpty();
    }
}
