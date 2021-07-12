package www.day3.generic4;

import java.util.ArrayList;

public class DemoGeneric42 {
    public static void main(String[] args) {

//        F<String> stringF = new F<>();
//        String ft = stringF.ft;

//        S1 s1 = new S1();
//        Object ft = s1.ft;

        S2 s2 = new S2();
        String ft = s2.ft;

        S3 s3 = new S3();
        Integer ft1 = s3.ft;

        S4<String> stringS4 = new S4<>();
        Float ft2 = stringS4.ft;


        S5<Integer> integerS5 = new S5<Integer>();
        Integer ft3 = integerS5.ft;

        S6<String> stringS6 = new S6<>();
        String ft4 = stringS6.ft;

        SS1 ss1 = new SS1();
        String ft5 = ss1.ft;

        SS2<Integer> integerSS2 = new SS2<Integer>();
        Integer ft6 = integerSS2.ft;


        ArrayList<String> list = new ArrayList<>();
        list.add("zs");

    }
}

class F<T>{
    T ft;
}
//class S1 extends  F{ }
class S2 extends F<String>{}
class S3 extends F<Integer>{}
class S4<E> extends F<Float>{}
class S5<E> extends F<E>{}
class S6<T> extends F<T>{}

class SS1 extends S6<String>{}
class SS2<E> extends S6<E>{}


class MyArrayList<E>{
    public boolean add(E e){
        return true;
    }
}
