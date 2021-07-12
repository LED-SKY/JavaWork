package stage9.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface StudentAnno {
    int minAge();

    int maxAge();

    String[] gradeType();

    String[] genderType();

    int nameLimit();

    int phoneNumLimit() default 8;
}
