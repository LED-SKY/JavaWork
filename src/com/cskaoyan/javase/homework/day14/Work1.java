package com.cskaoyan.javase.homework.day14;

import java.util.Arrays;

/**
 * @description: 自然排序练习题
 * @author: wuguidong@cskaoyan.onaliyun.com
 **/

/**
 * 1，实现Comparable接口，按照年龄的从小到大对Cat数组进行自然排序
 *
 * 2，利用Comparator接口，用 匿名内部类和lambda分别对Cat数组进行自然排序
 *    1，按照price的大到小排序
 *    2，name的长短排序，name越长对象越大
 *
 *    3，综合age，name，price进行排序，要求用lambda表达式指向一个方法。
 * 排序的规则是age越小对象越小，age相同比较name长短，name越短对象越小，name长度也相等，比较price，price越大对象越小
 *
 */
public class Work1 {
    public static void main(String[] args) {
        Cat c1 = new Cat(1, "马云mmm", 10);
        Cat c2 = new Cat(2, "马云的猫", 2000);
        Cat c3 = new Cat(1, "马云的猫", 10000);
        Cat c4 = new Cat(1, "马云的猫", 1000);
        Cat[] arr = {c1, c2, c3, c4};
        System.out.println(Arrays.toString(arr));
        //排序条件3
        //Arrays.sort(arr, Demo::myCompare);
        //System.out.println(Arrays.toString(arr));

        //排序条件2 name的长短排序，name越长对象越大
        //Arrays.sort(arr, (o1, o2) -> o1.name.length() - o2.name.length());

        //排序条件1 按照price的大到小排序
       
        Arrays.sort(arr, (o1, o2) -> ((int) (o2.price - o1.price)));
        System.out.println(Arrays.toString(arr));


    }

    public static int myCompare(Cat c1, Cat c2) {
        //比较规则1：年龄越小，排序中的位置越靠前
        if (c1.age != c2.age) {
            return c1.age - c2.age;
        }
        //比较规则2：姓名越短，排序中的位置越靠前
        else if (c1.name.length() != c2.name.length()) {
            return c1.name.length() - c2.name.length();
        }
        //比较规则3：价钱越高，排序中的位置越靠前
        else if (Double.compare(c1.price, c2.price) != 0) {
            return ((int) (c2.price - c1.price));
        }
        //上述规则都不满足，表示三个参数都是相等，对象相等
        else return 0;
    }
}

class Cat implements Comparable {
    int age;
    String name;
    double price;

    public Cat() {
    }

    public Cat(int age, String name, double price) {
        this.age = age;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Cat compareCat = (Cat) o;

        return this.age - compareCat.age;


    }
}
