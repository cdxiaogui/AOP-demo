package com.syw.logtest.aspect;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ShopLevelLog {
    String value() default "";
    int a () default 1;
}
