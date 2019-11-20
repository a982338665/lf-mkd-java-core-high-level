package pers.li.annotation.$6;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)

public @interface Fruit2 {
	String name() default "";
}
