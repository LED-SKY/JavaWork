package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: Stage1
 * @description: 反射获取构造方法
 * @author: 邓造坚
 * @create: 2021-07-06 22:58
 **/
public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> studentClass = Class.forName("reflect.Student");
        //获取全部构造方法
        Constructor<?>[] declaredConstructors = studentClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        System.out.println("--------------------------------------------");
        //只获取公共的构造方法
        Constructor<?>[] constructors = studentClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("--------------------------------------------");

        //获取单个公共的构造方法,括号里放要获取的构造方法的形参列表
        Constructor<?> constructor = studentClass.getConstructor();
        System.out.println(constructor);
        //创建实例,通过newInstance方法根据指定的构造方法来创建实例  括号里可以带形参
        Object obj = constructor.newInstance();
        System.out.println(obj);

        //获取带形参列表的单个构造方法。并创建实例,可以获取所有访问修饰符的
        Constructor<?> con = studentClass.getDeclaredConstructor(int.class);
        //设置允许访问，暴力反射，public和protected修饰的方法不需要暴力反射
        con.setAccessible(true);
        Object o = con.newInstance(1);
        System.out.println(o);

        //获取公共的单个构造方法，并创建实例
        Constructor<?> con2 = studentClass.getConstructor(String.class);
        Object o2 = con2.newInstance("李四");
        System.out.println(o2);
        System.out.println("--------------------------------------------");

        //获取所有的公共的成员变量
        Field[] fields = studentClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("--------------------------------------------");

        //获取所有成员变量，包括私有的和受保护的
        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        //获取所有公共的成员变量
        Field[] fields1 = studentClass.getFields();
        
        //获取单个公共的成员变量,括号的参数是Student类的字段名
        Field numField = studentClass.getField("num");

        //获取无参构造方法，创建对象
        Constructor<?> constructor1 = studentClass.getConstructor();
        Object o1 = constructor1.newInstance();

        //Field类提供set方法给单个字段进行赋值，意思是给o1对象的成员变量numField  赋值
        numField.set(o1, 2);
        System.out.println(o1);

        //用无参构造方法，创建对象
        Constructor<?> constructor2 = studentClass.getConstructor();
        Object o3 = constructor2.newInstance();

        //给多个成员变量赋值
        Field stuIdField = studentClass.getDeclaredField("stuId");
        stuIdField.setAccessible(true);
        stuIdField.set(o3, 2);

        Field nameField = studentClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(o3, "wang");
        System.out.println(o3);

        System.out.println("--------------------------------------------");

        //获取全部方法
        Method[] declaredMethod = studentClass.getDeclaredMethods();
        for (Method method : declaredMethod) {
            System.out.println(method);
        }
        System.out.println("--------------------------------------------");

        //获取方法,包括接口
        Method[] methods = studentClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        //获取单个没有形参列表的方法,
        Method m = studentClass.getMethod("method");

        //通过对象调方法
        Constructor<?> constructor3 = studentClass.getConstructor();
        Object o4 = constructor3.newInstance();

        m.invoke(o4);


        //获取单个有形参列表的方法
        Method method2 = studentClass.getMethod("method2", int.class);
        Constructor<?> constructor4 = studentClass.getConstructor();
        Object o5 = constructor4.newInstance();

        Object invoke = method2.invoke(o5, 13);
        System.out.println(invoke);


        //获取单个私有方法
        Method method3 = studentClass.getDeclaredMethod("method3");
        Constructor<?> constructor5 = studentClass.getConstructor();
        Object o6 = constructor5.newInstance();

        method3.setAccessible(true);
        method3.invoke(o6);
        
        
    }
}
