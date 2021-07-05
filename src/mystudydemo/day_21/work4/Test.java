package mystudydemo.day_21.work4;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-01 22:21
 * <p>
 * **启动2个线程 打印100个数** (使用wait notify)
 * 线程a 打印 1 3 5 7 9 ...奇数
 * 线程b 打印 2 4 6 8 10 ...偶数
 * 分析：线程a打印的是奇数 线程b打印的是偶数
 **/
public class Test {
    public static void main(String[] args) {
        //创建共享区域的类对象 
        Count count = new Count();
        //创建线程a和线程b的对象
        ThreadA a = new ThreadA(count);
        ThreadB b = new ThreadB(count);
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t1.setName("线程a---");
        t2.setName("线程b---");
        t1.start();
        t2.start();
    }

}
//打印奇数
class ThreadA implements Runnable {
    //锁对象
    Count c;

    public ThreadA(Count count) {
        this.c = count;
    }
    @Override
    public void run() {
        while (true) {
            //控制输出的范围
            if (c.number > 99) {
                break;
            }
            c.ood();
        }

    }
}
//打印偶数
class ThreadB implements Runnable {
    //锁对象
    Count c;

    public ThreadB(Count count) {
        this.c = count;
    }

    @Override
    public void run() {
        while (true) {
            if (c.number > 100) {
                break;
            }
            c.even();
        }
    }
}
//共享数据区
class Count {
    int number = 1;
    private boolean status = false;

    public synchronized void ood() {
        //第一次输出的是奇数，所以第一次不需要进行阻塞，直接运行到输出语句
        if (status) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "打印奇数：" + number++);
        //为了在下一次线程a 和线程b抢占CPU的时候去让线程a进入等待状态
        status = true;
        //输出了奇数之后需要唤醒等待状态的线程b
        notify();
    }

    public synchronized void even() {
        //第二次打印，才是偶数的第一次打印所以第一次的时候需要阻塞线程b
        if (!status) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "打印偶数：" + number++);
        //为了在下一次线程a 和线程b抢占CPU的时候去让线程b进入等待状态
        status = false;
        //输出了偶数需要唤醒线程a 去打印奇数
        notify();
    }

}