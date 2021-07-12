package reflect.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @program: Stage1
 * @description: 反射操作注解
 * @author: 邓造坚
 * @create: 2021-07-07 23:48
 **/
public class Demo3 {
    //测试
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
       //获取Class对象
        Class<?> c1 = Class.forName("reflect.annotations.Student");
        //通过反射获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获得注解的value值
        ClassAnno classAnno = c1.getAnnotation(ClassAnno.class);
        String value =classAnno.value();
        System.out.println(value);
        //获得类指定的注解
        Field f = c1.getDeclaredField("name");
        FieldAnno fieldAnno = f.getAnnotation(FieldAnno.class);
        System.out.println(fieldAnno.columnName());
        System.out.println(fieldAnno.type());
        System.out.println(fieldAnno.length());
     
    }
}
@ClassAnno(value =  "student")
class Student{
    @FieldAnno(columnName = "db_id",type = "int",length = 10)
    private int id;
    @FieldAnno(columnName = "db_name",type = "varchar",length = 3)

    public String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

//自定义注解,类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface ClassAnno{
    String value();
}

//自定义注解，属性的注解
@Retention(RetentionPolicy.RUNTIME)
@interface FieldAnno{
    String columnName();
    String type();
    int  length();
}