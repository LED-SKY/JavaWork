package www.day3.generic9;

import java.util.ArrayList;

public class DemoGeneric92 {
    public static void main(String[] args) {

//        ①	 泛型通配符<?> 通配任意类型(代指任意类型)，
//        如果没有明确，那么就是Object以及任意的Java类了

//       ② ? extends E 向下限定，E及其子类 (可以代指E及其子类)，
        ArrayList<? extends  F> list1 = new ArrayList<F>();
        ArrayList<? extends  F> list2 = new ArrayList<S1>();
        ArrayList<? extends  F> list3 = new ArrayList<S2>();
        // 报错: Object 不是F 或者F的子类
//        ArrayList<? extends  F> list4 = new ArrayList<Object>();



//        ③ ? super E 向上限定，E及其父类(可以代指E及其父类)，

        ArrayList<? super   F> list21 = new ArrayList<F>();
        ArrayList<? super   F> list22 = new ArrayList<Object>();

        // 报错: S1 和S2 不是F或者F的分类
//        ArrayList<? super   F> list23 = new ArrayList<S1>();
//        ArrayList<? super   F> list24 = new ArrayList<S2>();


    }
}

class F {}
class S1 extends F{}
class S2 extends F{}
