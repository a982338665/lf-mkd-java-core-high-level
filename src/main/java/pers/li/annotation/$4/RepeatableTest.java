package pers.li.annotation.$4;

import pers.li.annotation.$4.repeatable.RepeatableAnnotation;
import pers.li.annotation.$4.repeatable.RepeatableAnnotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * 可重复注解
 */
public class RepeatableTest {
    public static void main(String[] a) throws Exception {
        String className = "pers.li.annotation.$4.Students";
        for (Method m : Class.forName(className).getMethods()) {
            //判断方法上是否有隐藏的容器注解
            if (m.isAnnotationPresent(bases.class)) {
                //获取重复注解内容
                base[] annos = m.getAnnotationsByType(base.class);
                for (base anno : annos) {
                    System.out.println(anno.a() + "," + anno.b() + "," + anno.c());
                    try {
                        m.invoke(null, anno.a(), anno.b(), anno.c());
                    } catch (Throwable ex) {
                        System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                    }
                }
            }
        }
    }
}


/**
 * 定义可重复注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(bases.class)
//传入容器注解
@interface base {

    int a() default 0;

    int b() default 0;

    int c() default 0;
}

/**
 * 定义容器注解
 */
@Retention(RetentionPolicy.RUNTIME)
@interface bases {
    //申明可重复注解数组
    base[] value();
}


class Students {
    @base(a = 1, b = 2, c = 3)
    @base(a = 1, b = 2, c = 4)
    public static void add(int a, int b, int c) {
        if (c != a + b) {
            throw new ArithmeticException("Wrong");
        }
    }
}
