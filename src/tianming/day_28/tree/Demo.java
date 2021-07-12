package tianming.day_28.tree;

/**
 * @program: Stage1
 * @description: 二叉搜索树的测试实例
 * @author: 邓造坚
 * @create: 2021-07-10 11:36
 **/
public class Demo {
}

//定义对象能实现比较大小
class User implements Comparable<User>{

    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        
        //比较原则：1、首先比较名字，名字不相等则返回名字的长度差
        //2、名字相等的话，就去比较年龄，返回年龄的差
        
        int com = name.compareTo(o.name);
        com = com == 0 ? age - o.age:com;
        return com;
    }
}