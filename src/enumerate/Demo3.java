package enumerate;

import javax.xml.transform.Source;

/**
 * @program: Stage1
 * @description: 演示枚举对象的方法
 * @author: 邓造坚
 * @create: 2021-07-10 15:56
 **/
public class Demo3 {
    public static void main(String[] args) {

        Season3 autumn = Season3.AUTUMN;
        //返回当前对象名
        System.out.println(autumn.toString());
        //获取当前对象名
        System.out.println(autumn.name());
        //返回当前位置号，默认从0开始
        System.out.println(autumn.ordinal());
        //返回当前枚举类中的所有常量
        Season3[] values = Season3.values();
        for (Season3 value : values) {
            System.out.println(value);
        }
        //将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报异常
        Season3 summer = Season3.valueOf("SUMMER");
        System.out.println(summer);
        //比较两个枚举常量，比较的是位置号
        System.out.println(autumn.compareTo(summer));
    }
}

//enum关键字实现枚举类
enum Season3 {
    //实现步骤：
    //1. 使用关键字enum来代替class
    //2. 创建常量对象    SPRING("春天","温暖");---->常量名（实参列表）
    //3. 多个常量对象，用,号隔开
    //4. 要求常量对象写在前面
    SPRING("春天","温暖"),WINIER("冬天","寒冷"),AUTUMN("秋天","凉爽"),SUMMER("夏天","炎热");
    private String name;//季节
    private String desc;//描述

    private Season3(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

}