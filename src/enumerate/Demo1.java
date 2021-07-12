package enumerate;

/**
 * @program: Stage1
 * @description: 自定义枚举使用
 * @author: 邓造坚
 * @create: 2021-07-10 15:56
 **/
public class Demo1 {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN.getName());
    }
}

class Season{
    private String name;//季节
    private String desc;//描述

    //定义四个对象，固定不变
    public static final Season SPRING = new Season("春天","温暖");    
    public static final Season WINIER = new Season("冬天","寒冷");    
    public static final Season AUTUMN = new Season("秋天","凉爽");    
    public static final Season SUMMER = new Season("夏天","炎热");    
    //构造器私有化
    private Season(String name, String desc) {
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