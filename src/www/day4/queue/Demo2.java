package www.day4.queue;

public class Demo2 {
    public static void main(String[] args) {


        MyArrayQueue<String> queue = new MyArrayQueue<>(4);

        queue.offer("zs");
        queue.offer("ls");
        queue.offer("wu");
        queue.offer("zl");
        //  zs  ls  wu  zl
        //  0   1   2   3
        // head         end


        //  zs  ls  wu  zl
        //  0   1   2   3
        //     head     end
        String poll = queue.poll();


        //  aa  ls  wu  zl
        //  0   1   2   3
        // end head
        queue.offer("aa");


        //  ls  wu  zl  aa  bb
        //  0   1   2   3   4   5   6   7
        // head            end
        queue.offer("bb");



        System.out.println(queue);

    }
}
