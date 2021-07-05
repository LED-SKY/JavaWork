package threaddemo;

import java.util.LinkedList;

/**
 * @program: Stage1
 * @description: 生产者和消费者模式
 * @author: 邓造坚
 * @create: 2021-07-04 00:03
 * <p>
 * 4S店最多存4台车
 * 生产者生产满4台不继续生产
 * 消费者在4S店没车时不能购买
 **/
public class ProductAndConsumer {

    public static void main(String[] args) {
        //库存4S汽车店
        Car4S car4S = new Car4S();
        new Thread(new ProductCar(car4S)).start();//生产者线程启动
        new Thread(new ConsumerCar(car4S)).start();//消费者线程启动
    }
}

//Car4S库存区
class Car4S {
    //创建队列
    LinkedList carList = new LinkedList();
    //生产的汽车序号
    int carNum = 1;
}

//生产者
class ProductCar implements Runnable {
    //共享库存区
    Car4S car4S = new Car4S();

    public ProductCar(Car4S car4S) {
        this.car4S = car4S;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (car4S) {
                if (car4S.carList.size() < 4) {
                    //4S 店没满可以继续生产
                    Car car = new Car();
                    car.setName(car4S.carNum + "");
                    System.out.println("生产了一台汽车，编号为：" + car.getName());
                    car4S.carNum++;
                    car4S.carList.push(car);
                    car4S.notifyAll();
                } else {
                    //库存已满停止生产,进入等待状态
                    try {
                        car4S.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

//消费者
class ConsumerCar implements Runnable {

    Car4S car4S = new Car4S();

    public ConsumerCar(Car4S car4S) {
        this.car4S = car4S;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (car4S) {
                if (car4S.carList.size() > 0) {
                    Car car = new Car();
                    car.setName(car4S.carNum + "");
                    car4S.carNum--;
                    Car poll = ((Car) car4S.carList.poll());
                    System.out.println("消费了第" + poll.getName() + "辆汽车");
                    car4S.notifyAll();
                } else {
                    try {
                        car4S.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

//汽车实体类
class Car {
    String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}