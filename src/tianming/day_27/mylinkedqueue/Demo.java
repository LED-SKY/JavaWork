package tianming.day_27.mylinkedqueue;

/**
 * @program: Stage1
 * @description: 测试用链表实现的队列的代码
 * @author: 邓造坚
 * @create: 2021-07-09 15:17
 **/
public class Demo {
    public static void main(String[] args) {
        MyLinkedQueue<String> queue = new MyLinkedQueue<>();
        queue.offer("zs");
        queue.offer("ls");
        queue.offer("wu");
        queue.offer("zl");
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}
