package threaddemo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: Stage1
 * @description: 创建线程方式
 * @author: 邓造坚
 * @create: 2021-07-06 15:33
 **/
public class CreateThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //方式一

        MyThread thread1 = new MyThread();
        thread1.start();
        
        //方式二
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();
        
        //方式三
        CallableThread callableThread = new CallableThread();
        FutureTask<String> task = new FutureTask<String>(callableThread);
        Thread thread3 = new Thread(task);
        thread3.start();
        //捕获异常抛出，必须放在start后面才会返回call方法里的值
        String s = task.get();
        System.out.println(s);
    }
    //方式一类继承Thread
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("这是方式一的线程创建方式");
        }
    }
    
    //方式二类实现Runnable
    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("这是方式二的线程创建方式");
        }
    }
    //方式三,带返回值
    static class  CallableThread  implements Callable<String>{


        @Override
        public String call() throws Exception {
            return  "这是方式三的线程创建方式";
        }
    }
}

