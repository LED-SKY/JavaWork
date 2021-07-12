package threaddemo.threadTest;

import java.util.concurrent.*;

/**
 * @program: Stage1
 * @description: 线程测试案例
 * @author: 邓造坚
 * @create: 2021-07-06 09:02
 **/
public class Demo2 {
    public static volatile boolean flag = true;

    public static void main(String[] args) {

        //演示线程，输入stop时候
        new Thread(()->{
            
            
        }).start();
        
        
        //创建线程池
        ExecutorService es = new ThreadPoolExecutor(
                2,
                5,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        for (int i = 0; i < 20; i++) {
            es.execute(new MyRunnable("第" + (i + 1) + "号任务"));

            System.out.println("丢弃任务" + (i + 1));
        }
    }

    private static class MyRunnable implements Runnable {
        private String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        public MyRunnable() {
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "===>" + name);
            while (flag) {
                //flag是一个开关，为true时线程任务会一直执行让线程一直执行
            }
        }
    }
}
