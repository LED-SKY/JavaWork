package www.day3.generic9;

import java.util.ArrayList;

public class DemoGeneric91 {
    public static void main(String[] args) {

//        ①	 泛型通配符<?> 通配任意类型(代指任意类型)，
//        如果没有明确，那么就是Object以及任意的Java类了
//       ② ? extends E 向下限定，E及其子类
//        ③ ? super E 向上限定，E及其父类

        ArrayList<String> list1 = new ArrayList<>();

        ArrayList<Object> list2 = new ArrayList<>();

      // ? 可以代指任何类型
        ArrayList<?> list3 = list1;
        list3 = list2;

    }
}
