package threaddemo.threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: Stage1
 * @description: 线程池的几种工具类
 * @author: 邓造坚
 * @create: 2021-07-05 22:18
 **/
public class Demo1 {
    public static void main(String[] args) {
//        pool1();
//        pool2();
//        pool3();
        pool4();
    }
    
    

    public static void pool1() {
        //可缓存线程池，无限大小线程池，JVM自动回收
        ExecutorService pool1 = Executors.newCachedThreadPool();
        //创建10个线程  分别执行任务
        for (int i = 0; i < 10; i++) {
            pool1.execute(() -> {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 10; j++) {

                    System.out.println(Thread.currentThread().getName() + ":" + j);
                }
            });

        }
        pool1.shutdown();
    }

    public static void pool2() {
        //定长的线程池
        ExecutorService pool2 = Executors.newFixedThreadPool(2);
        //创建10个线程  分别执行任务
        for (int i = 0; i < 10; i++) {
            pool2.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "::::>" + j);
                }
            });

        }
        pool2.shutdown();
    }
    
    public static void pool3(){
        //创建一个线程池里面只有一个线程，保证所有任务按照指定的顺序执行
        ExecutorService pool3 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < 10; j++) {
                System.out.println(Thread.currentThread().getName() + ":" +  j);
            }
        }
        pool3.shutdown();
    }
    
    public static void pool4(){
        //创建一个调度线程池
        ScheduledExecutorService pool4 = Executors.newScheduledThreadPool(5);
        //延时执行
        //参数：任务，延时时间，时间单位
        pool4.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("i:" +1);
            }
        },4,TimeUnit.SECONDS);
        
        //周期性执行
        //参数：任务，延时时间，间隔时间，时间单位
        pool4.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("j:" + 2);
            }
        },3,4,TimeUnit.SECONDS);
    }
}
