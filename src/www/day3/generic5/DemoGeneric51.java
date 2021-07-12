package www.day3.generic5;

import java.util.ArrayList;

public class DemoGeneric51 {
    public static void main(String[] args) {


        ArrayList<String> list = new ArrayList<>();

    }
}

interface F<T>{
   T getT();
}
class S implements F{
    @Override
    public Object getT() {
        return null;
    }
}

class S2 implements F<String>{

    @Override
    public String getT() {
        return null;
    }
}

class S3<E> implements F<E>{

    @Override
    public E getT() {
        return null;
    }
}

class S4<T> implements F<T>{

    @Override
    public T getT() {
        return null;
    }
}


