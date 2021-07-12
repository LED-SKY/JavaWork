package tianming.day_26.genericity;

public class Demo {
    public static void main(String[] args) {
        MyDBLinked<String> linked = new MyDBLinked<>();
//        linked.add("zs");
//        linked.add(1, "ls");
//        linked.add(2, "wu");
//        linked.add("zl");
//        System.out.println(linked);
//        System.out.println(linked.contains("ss"));//按内容查找
//        System.out.println(linked.set("ls", "xl"));//按内容替换
//        System.out.println(linked);
//        System.out.println(linked.getData(1));//按下标查找
//        linked.setData(1, "ls");//按下标替换
        MyDBLinked<Integer> list = new MyDBLinked<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);
//        list.remove(3);
        list.set(3,1);
        
        System.out.println(list.contains(3));
        
        System.out.println(list);
    }
}
