package com.example.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解string 类型的字段
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {
    //字段名
    String name() default "";

    //类型的长度 列如varchar(30) 中的30
    int value() default 0;

    Constraints constraint() default @Constraints;
}
