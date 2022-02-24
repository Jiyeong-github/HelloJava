package dev;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
//.Class(로더), .Source(컴파일러), .Runtime(한 번 돌 때까지 살아있게 할려면)
public @interface MyAnnotation {
    int num();
    String name() default "MyName";

}
