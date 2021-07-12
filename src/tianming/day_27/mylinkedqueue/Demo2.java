package tianming.day_27.mylinkedqueue;

/**
 * @program: Stage1
 * @description: 测试用数组实现的队列的情况
 * @author: 邓造坚
 * @create: 2021-07-09 23:10
 **/
public class Demo2 {
    public static void main(String[] args) {
        MyArrayQueue<Integer> list = new MyArrayQueue<>();
        list.offer(1);
        list.offer(2);
//        list.offer(3);
        System.out.println(list.poll());
//        System.out.println(list.peek());
        System.out.println(list);
    }
}
