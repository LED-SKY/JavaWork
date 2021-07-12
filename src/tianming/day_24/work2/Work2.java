package tianming.day_24.work2;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

/**
 * @program: Stage1
 * @description: 判断链表是否有环，打印环首位的节点数据
 * @author: 邓造坚
 * @create: 2021-07-06 20:16
 **/
public class Work2 {
    //保存已经经过的节点
    static ArrayList<Node> nodes = new ArrayList<Node>();
    //首次找到环首节点的下标
    static int num = -1;
    
    public static void main(String[] args) {
        //无环单链表
        Node singleNode1 = new SingleNode("1");
        Node singleNode2 = new SingleNode("2");
        Node singleNode3 = new SingleNode("3");
        Node singleNode4 = new SingleNode("4");
        singleNode1.next = singleNode2;
        singleNode2.next = singleNode3;
        singleNode3.next = singleNode4;
        boolean bool1 = hasCircle(singleNode1);
        System.out.println("单链表：" +bool1);

        
        //有环循环列表
        LoopNode loopNode1 = new LoopNode("zs");
        LoopNode loopNode2 = new LoopNode("ls");
        LoopNode loopNode3 = new LoopNode("wu");
        LoopNode loopNode4 = new LoopNode("zz");
        loopNode1.next = loopNode2;
        loopNode2.next = loopNode3;
        loopNode3.next = loopNode4;
        loopNode4.next = loopNode2;

        boolean bool2 = hasCircle(loopNode1);
        System.out.println("循环列表：" + bool2);
        //返回环的起始位置的存储的内容
        System.out.println(nodes.get(num));
    }

    //判断输入的链表头结点所在的链表是否有环
    private static boolean hasCircle(Node node) {

        //循环控制条件
        boolean flag = true;

        while (flag) {
            //下一个节点不为空则进入下一节点比较
            if (node.next != null){
                nodes.add(node);
                //判断是否找到指定的元素
                num = nodes.indexOf(node.next);
                if (num > 0){
                    //找到则结束循环
                    flag = false;
                }else {
                    //没找到继续向下一节点出发
                    node = node.next;
                }
            }else {
                //没有环时则返回false
                return false;
            }
        }

        return true;

    }

    //父类的Node
    static class Node {
        String data;
        Node next;

        public Node() {
        }
    }

    //单链表
    static class SingleNode extends Node {

        public SingleNode(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "SingleNode{" +
                    "data='" + data + '\'' +
                    '}';
        }
    }

    //循环链表
    static class LoopNode extends Node {

        public LoopNode(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "LoopNode{" +
                    "data='" + data + '\'' +
                    '}';
        }
    }
}
