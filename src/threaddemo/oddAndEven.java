package threaddemo;

/**
 * @program: Stage1
 * @description: 用wait()和notify()控制a、b线程交替打印
 * @author: 邓造坚
 * @create: 2021-07-03 23:16
 **/
public class oddAndEven {
    public static void main(String[] args) {
        Num num = new Num();
        new Thread(new oddThread(num)).start();//奇数线程启动
        new Thread(new evenThread(num)).start();//偶数线程启动
    }
}

class Num {
    int num = 1;
}

//打印奇数线程 
class oddThread implements Runnable {

    //共享资源
    private Num numObj;

    oddThread(Num numObj) {
        this.numObj = numObj;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (numObj) {
                if (numObj.num < 101) {
                    if (numObj.num % 2 != 0) {
                        System.out.println("奇数线程打印===》" + numObj.num);
                        //唤醒evenThread线程
                        numObj.num++;
                        numObj.notify();
                    } else {
                        //偶数的时候，自身进入等待状态
                        try {
                            numObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else break;
            }

        }

    }
}

//打印偶数线程
class evenThread implements Runnable {
    //共享资源
    private Num numObj;

    evenThread(Num numObj) {
        this.numObj = numObj;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (numObj) {
                if (numObj.num < 101) {
                    if (numObj.num % 2 == 0) {
                        System.out.println("偶数线程打印===》" + numObj.num);
                        numObj.num++;
                        //唤醒奇数打印线程
                        numObj.notify();
                    } else {
                        try {
                            numObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                } else break;
            }
        }
    }
}