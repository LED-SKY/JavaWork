package reflect.annotations;

/**
 * @program: Stage1
 * @description: 自定义注解
 * @author: 邓造坚
 * @create: 2021-07-07 23:39
 **/
public class Demo2 {
    //注解可以显示赋值，如果没有默认值就必须给注解显示赋值
    @MyAnnotation2(name = "zhangsan",id =1)
    public static void main(String[] args) {
        
    }
}
@interface MyAnnotation2{
    //注解的参数：参数类型+参数名（）
    String name()default "";
    int id();
}