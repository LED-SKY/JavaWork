package www.day3.generic8;

public class DemoGeneric81 {
    public static void main(String[] args) {

        // 父类引用指向之类对象
//        Object obj = new String("zs");



        // TODO: 不是父类引用指向之类对象: 因为strs, objs 是个数组
        // 协变
        // 在jvm中数组是一个非非常常特殊的存在, jvm对数组做了很多适配
        // 这个能指向不是父类引用指向之类对象, 只是jvm的特殊处理
        String [] strs = new String[10];
        Object [] objs = strs;

        // objs 本质指向的是一个String类型的数组
//        objs[0] = 10;


    }
}
