package www.day4.queue;

import java.util.ArrayDeque;

public class Demo1 {
    public static void main(String[] args) {

//        ArrayDeque<String> queue = new ArrayDeque<>();
//        queue.offer("zs");
//        queue.poll();
//        queue.peek();

        MyLinkedQueue<String> queue = new MyLinkedQueue<>();

        queue.offer("zs");
        queue.offer("ls");
        queue.offer("wu");
        queue.offer("zl");

        //zs   -- ls   -- wu   -- zl
        //队头                     队尾

        String poll = queue.poll();
        System.out.println(queue.peek());

        System.out.println(queue);



    }
}
