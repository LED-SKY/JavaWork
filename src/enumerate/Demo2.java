package enumerate;

/**
 * @program: Stage1
 * @description: enum 关键字实现枚举类
 * @author: 邓造坚
 * @create: 2021-07-10 15:56
 **/
public class Demo2 {
    public static void main(String[] args) {
        System.out.println(Season2.AUTUMN);
    }
}

//enum关键字实现枚举类
enum Season2 {
    //实现步骤：
    //1. 使用关键字enum来代替class
    //2. 创建常量对象    SPRING("春天","温暖");---->常量名（实参列表）
    //3. 多个常量对象，用,号隔开
    //4. 要求常量对象写在前面
    SPRING("春天","温暖"),WINIER("冬天","寒冷"),AUTUMN("秋天","凉爽"),SUMMER("夏天","炎热");
    private String name;//季节
    private String desc;//描述

    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}