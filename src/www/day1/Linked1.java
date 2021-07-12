package www.day1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Linked1 {
    public static void main(String[] args) {

//        int i = 1;
//        User zs = new User("zs", 18);
//        User[] myclass = new User[50];


        ArrayList list = new ArrayList();
        for (int j = 0; j < 50; j++) {
            list.add(new User("zs", j));
        }
        // 新来
        list.add(new User("zs", 10));

        // 走了
        list.remove(new User("zs", 10));
        list.remove(0);

//-----------------------------------------------------------

        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(new User("zs", 10)  );
        myArrayList.remove(new User("zs", 10)  );


        LinkedList linkedList = new LinkedList();
        linkedList.add("zs");

    }
}
//arraylist  底层是一个数组,  添加和删除的效率 ?   时间复杂度
class MyArrayList{
    Object [] arr;
    int size;// 添加的元素数目

    public MyArrayList(){
        arr = new Object[10];
    }
    public void add(User user){
        // 判断底层数组是否满了
        if (arr.length == size){
            // 扩容
            int newLen = size* 2;
            Object[] objects = new Object[newLen];
            for (int i = 0; i < arr.length; i++) {
                objects[i] = arr[i];
            }
            arr = objects;
        }

        arr[size++] = user;
    }

    public void remove(User zs) {

        for (int i = 0; i < arr.length; i++) {

        }


    }
}

class User{
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
