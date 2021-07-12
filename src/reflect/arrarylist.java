package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-07 22:33
 * 
 * 通过反射，越过泛型检查，
 **/
public class arrarylist {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> integers = new ArrayList<>();
        
        //获取Class对象
        Class<? extends ArrayList> aClass = integers.getClass();
        Method add = aClass.getMethod("add", Object.class);
        add.invoke(integers,"hello");
        add.invoke(integers,"aaaa");
        System.out.println(integers);
    }
}
