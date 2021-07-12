package tianming.day_27.Work1;

/**
 * @program: Stage1
 * @description: 测试数组编写的线性表
 * @author: 邓造坚
 * @create: 2021-07-09 20:33
 **/
public class Demo {

    public static void main(String[] args) {
        MyListArray<Integer> list = new MyListArray<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(2);
        System.out.println(list);
//        System.out.println(list.remove(2));
        System.out.println(list.contains(2));
//        list.set(2,6);
//        list.addData(5,5);
//        list.removeData(4);
        System.out.println(list.getData(3));
        list.setData(3,6);
        System.out.println(list);
        

    }
}
