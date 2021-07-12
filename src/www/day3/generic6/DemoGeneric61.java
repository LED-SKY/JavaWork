package www.day3.generic6;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.ArrayList;

public class DemoGeneric61 {
    public static void main(String[] args) {

//        用到了泛型的方法不是泛型方法, 定义了泛型的方法才是泛型方法
//        把泛型定义在方法上
//        格式:  <泛型类型> 返回类型 方法名(泛型类型 .)

        A a = new A();

        // 自动根据上下文做类型推断
        Integer a1 = a.getA(1);
        String zs = a.getA("zs");
        A a2 = a.getA(new A());


        // 那个地方会用到泛型方法
        ArrayList<String> list = new ArrayList<>();
        list.add("zs");
        list.add("ls");
        System.out.println(list);


//        Object[] objects = list.toArray();
//        for (int i = 0; i < objects.length; i++) {
//            System.out.println(objects[i]);
//        }

//        String [] strs = new String[2];
//        String[] strings = list.toArray(strs);
//        for (int i = 0; i <strings.length ; i++) {
//            System.out.println(strings[i]);
//        }


        Integer [] strs = new Integer[2];
        Integer[] strings = list.toArray(strs);
        for (int i = 0; i <strings.length ; i++) {
            System.out.println(strings[i]);
        }

//        Object[] ints = new Integer[10];
//        ints[0] = "zs";



    }
}

class A {

    public <T> T getA(T t){

        return t;
    }

//    public void add(T t){
//
//    }
}
