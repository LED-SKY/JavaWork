package tianming.day_26.genericity;

import java.util.ArrayList;

/**
 * @program: Stage1
 * @description: 泛型方法
 * @author: 邓造坚
 * @create: 2021-07-08 16:42
 **/
public class Demo4 {
    public static void main(String[] args) {
        A a = new A();
        //自动根据上下文做类型推断
        Integer a1 = a.getA(1);
        String sas = a.getA("sas");
        A a2 = a.getA(new A());
        ArrayList<? super A> list = new ArrayList<>();
        list.add(new A());
        ArrayList<Integer> objects = new ArrayList<>();
        //报错
//        objects.add("aa");
    }
}

class A {

    public <T> T getA(T t) {
        return t;
    }
}