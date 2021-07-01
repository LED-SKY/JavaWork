package mystudydemo.day_20.practice;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-06-30 10:15
 **/
public class Demo {
    public static void main(String[] args) {
        //创建子类对象
        MyThread t1 = new MyThread();
//        MyThread t2 = new MyThread();
        t1.setDaemon(true);

        //启动线程
        t1.start();
//        t2.start();
        Thread.currentThread().setDaemon(true);
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i=0;i<8;i++){
            System.out.println(getName()+"------"+i);
            Thread.yield();
            
            
        }
    }
}