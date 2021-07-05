package mystudydemo.day_22.work1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-02 23:21
 * <p>
 * .创建一个任务，它将睡眠随机1-10s， 然后显示睡眠时间并退出。创建并运行一定数量的这个任务
 * ps:利用线程池
 **/
public class Test {

    public static void main(String[] args) {
        //创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(new MyTask());
        pool.submit(new MyTask());
        pool.submit(new MyTask());
        pool.submit(new MyTask());
        pool.shutdown();
    }
}

class MyTask implements Runnable {

    @Override
    public void run() {
        //创建1-10的随机数
        int time = ((int) (Math.random() * ((10 - 1) + 1)));
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "线程睡眠了" + time + "S");
    }
}