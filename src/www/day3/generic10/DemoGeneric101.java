package www.day3.generic10;

import java.util.ArrayList;

public class DemoGeneric101 {
    public static void main(String[] args) {


        // ? 可以代指所有
//        ArrayList<?> list = new ArrayList<String>();

        // 报错: 从编译角度, 不太确定这个? 代指的到底是个什么类型
        // 为了避免出现类似数组协变的时候, 类型不同在运行时的错误
        //  直接不让添加:
//        list.add(new F());
//        list.add(new Object());
//        list.add(new S1());
//        list.add(new S2());


//        ArrayList<? extends  F> list = new ArrayList<F>();
        // 不让添加,  原因是我仅能知道? extends  F 是代指F 或者F的某个子类
        // 具体是哪个东西, 是不太 确定的,
//        list.add(new F());
//        list.add(new Object());
//        list.add(new S1());
//        list.add(new S2());



        ArrayList<? super   F> list = new ArrayList<F>();
        list.add(new F());
        list.add(new S1());
        list.add(new S2());

// 不让添加,  原因是我仅能知道? super  F 是代指F 或者F的某个父类
        // 具体是哪个东西, 是不太 确定的, 不一定能容纳Object对象
//        list.add(new Object());


    }
}
class F{}
class S1 extends F{}
class S2 extends F{}

