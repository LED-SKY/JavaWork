package tianming.day_27.demo;

import tianming.day_27.mylinkedstack.MyArrayStack;

/**
 * @program: Stage1
 * @description: 实现括号匹配
 * @author: 邓造坚
 * @create: 2021-07-09 15:23
 **/
public class judgeBracket {
    public static void main(String[] args) {
        String str = " public static void main(String[] args) { }";
        String str2 = " {{public static void main(String[] args) { }";
        String str3 = " public static void main(String[] }args) { }";
        String str4 = " public static void{ main(String[] }args) { }";
        String str5 = " public static void main(St{ring[] }args) { }";
        boolean bool = judge(str);
        System.out.println(bool);
        System.out.println(judge(str2));
        System.out.println(judge(str3));
        System.out.println(judge(str4));
        System.out.println(judge(str5));
    }

    private static boolean judge(String str) {

        //数组栈，后进先出
        MyArrayStack<Character> stack = new MyArrayStack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //检测到一个左括号就往栈里存它的匹配的右括号
            if (c == '{') stack.push('}');
            if (c == '(') stack.push(')');
            if (c == '[') stack.push(']');
            if (c == ')' || c == '}' || c == ']') {
                //栈空。没有里面没有匹配的括号
                if (stack.isEmpty()) return false;
                //出栈最后进栈的括号
                Character pop = stack.pop();
                //最后进栈的括号不是先出的，说明括号不匹配
                if (!pop.equals(c)) return false;
            }
        }
        
        //循环出来则说明已经比较完，如果括号全部匹配则栈为空，否则是还有没有匹配到的括号栈不为空
        
        //栈不为空
        if (!stack.isEmpty()) return false;
        //栈为空
        return true;
    }
}
