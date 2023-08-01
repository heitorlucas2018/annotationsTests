package com.heitor.tests.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.TYPE})
@Implements(UUIDGenImpl.class)
public @interface UUIDGen {
    String key() default "";
}
