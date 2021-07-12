package reflect.annotations;

import java.lang.annotation.*;

/**
 * @program: Stage1
 * @description: 元注解测试
 * @author: 邓造坚
 * @create: 2021-07-07 23:30
 **/
public class Demo1 {
    @MyAnnotation
    public static void main(String[] args) {

    }
}


//定义一个注解
//@Target表示我们定义的注解可以作用的范围：METHOD 能放在方法上面；TYPE 能放在类上面

@Target(value = {ElementType.METHOD, ElementType.TYPE})

//Retention 表示我们的注解在什么时候还有效，（默认）RUNTIME  运行时还有效
@Retention(value = RetentionPolicy.RUNTIME)

//Documented 表示是否将我们的注解生成在Javadoc中
@Documented

//Inherited 表示子类可以继承父类的注解
@Inherited
@interface MyAnnotation {

}