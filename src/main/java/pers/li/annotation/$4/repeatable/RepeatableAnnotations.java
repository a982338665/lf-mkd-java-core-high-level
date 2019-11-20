package pers.li.annotation.$4.repeatable;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatableAnnotations {
	RepeatableAnnotation[] value();
}
