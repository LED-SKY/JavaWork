package mystudydemo.day_21.work1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-03 15:32
 **/
public class Test {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Thread.State state = Thread.currentThread().getState();
                    System.out.println(state);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
thread.start();
        Thread.State state = thread.getState();
       
        System.out.println(state);

    }
}
