package mystudydemo.day_21.work3;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-01 21:46
 * <p>
 * 用多线程代码来模拟，迅雷用3个线程下载100M资源的的过程**。
 * <p>
 * 每个线程每次，一次下载1兆(M)资源，直到下载完毕，即剩余的待下载资源大小为0
 * <p>
 * (用一个整数表示资源大小，每次个线程每次下载多少兆(M), 剩余待下载资源就减少多少兆(M)，
 * <p>
 * 模拟我们售票的代码实现，考虑多线程的数据安全问题)
 **/
public class Test {

    public static void main(String[] args) {
        DownloadResource down = new DownloadResource();
        Thread t1 = new Thread(down);
        Thread t2 = new Thread(down);
        Thread t3 = new Thread(down);
        t1.setName("子线程1");
        t2.setName("子线程2");
        t3.setName("子线程3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class DownloadResource implements Runnable {

    //总的资源大小100
    private int resource = 100;

    //锁对象
    private Object obj = new Object();
    //控制下载结束
    boolean flag = true;
    @Override
    public void run() {
        //共同代码，原子操作
            while (flag) {
                synchronized (obj) {

                    if (resource > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "已经下载" + (resource - (--resource)) + "M  总的资源剩余：" + resource + "M");
                    }else {
                        flag =false;
                    }
                
            }
        }
    }
}