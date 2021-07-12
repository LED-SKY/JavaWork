package reflect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @program: Stage1
 * @description: 通过配置文件来运行类中的方法
 * @author: 邓造坚
 * @create: 2021-07-07 22:43
 **/
public class properties {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //加载文件中的数据
        Properties prop = new Properties();
        FileReader fr = new FileReader("src/reflect/properties.txt");
        //载入数据
        prop.load(fr);
        fr.close();

        String className = prop.getProperty("className");
        String method = prop.getProperty("method");
        //通过反射来使用
        Class<?> c = Class.forName(className);
        Constructor<?> constructor = c.getConstructor();
        Object o = constructor.newInstance();

        Method method1 = c.getMethod(method);
        method1.invoke(o);


    }
}
