package pers.li.annotation.$6;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Fruit {
	String name() default "";
}

