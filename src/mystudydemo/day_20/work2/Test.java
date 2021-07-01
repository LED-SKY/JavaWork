package mystudydemo.day_20.work2;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-30 14:49
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
       
            MyThread1 t1 = new MyThread1();
            MyThread2 t2 = new MyThread2();
            MyThread3 t3 = new MyThread3();
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
         
  
    }
}
class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("这是T1线程");
    }
    
    
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        System.out.println("这是T2线程");
    }
}
class MyThread3 extends Thread{
    @Override
    public void run() {
        System.out.println("这是T3线程");
    }
}
