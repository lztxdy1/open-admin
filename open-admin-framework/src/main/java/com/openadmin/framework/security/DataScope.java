package com.openadmin.framework.security;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope {
    String deptAlias() default "d";
    String userAlias() default "u";
}
