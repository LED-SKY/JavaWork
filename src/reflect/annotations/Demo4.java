package reflect.annotations;

import java.lang.annotation.Annotation;

/**
 * @program: Stage1
 * @description: 获取注解
 * @author: 邓造坚
 * @create: 2021-07-12 14:47
 **/
public class Demo4 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("reflect.annotations.Demo1");
        Annotation[] declaredAnnotations = aClass.getAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {

            System.out.println(declaredAnnotation);
        }
        MyAnnotation declaredAnnotation = aClass.getDeclaredAnnotation(MyAnnotation.class);
        System.out.println(declaredAnnotation);
    }
}
