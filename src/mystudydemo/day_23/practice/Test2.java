package mystudydemo.day_23.practice;

import java.util.concurrent.*;

/**
 * @program: Stage1
 * @description: threadTest
 * @author: 邓造坚
 * @create: 2021-07-05 16:43
 **/
public class Test2 {
    public static void main(String[] args) {
        //threadTest
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,10, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10),new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(()->{

        });
        //设置核心线程超时销毁
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        //同步队列
        SynchronousQueue<Object> objects = new SynchronousQueue<>();
        //无界缓存等待队列
        LinkedBlockingQueue<Object> objects1 = new LinkedBlockingQueue<>();
        //有界缓存等待队列
        ArrayBlockingQueue<Object> objects2 = new ArrayBlockingQueue<>(4);
        System.out.println(decision());
        System.out.println(A.a);


    }
    static boolean decision() {
        try {
            return true;
        } finally {
            return false;
        }
    }
}
class A{
    static int a = 10;
    int b;

    public A(int b) {
        this.b = b;
    }
}
