package pers.li.annotation.$4;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 注解范围测试
 */
@J
public class TargetTest {


    @D
    private String name;

    @C
    public TargetTest(){

    }

    @F
    public void test(@G String test){
        @E
        String name = "li";

    }

}


/**
 * 修饰注解的注解
 */
@Target(ElementType.ANNOTATION_TYPE)
@interface A{

}
/**
 * 修饰注解的注解 测试
 */
@A
@interface B{

}

/**
 * 修饰构造方法的注解
 */
@Target(ElementType.CONSTRUCTOR)
@interface C{

}
/**
 * 修饰成员变量
 */
@Target(ElementType.FIELD)
@interface D{

}
/**
 * 修饰局部变量
 */
@Target(ElementType.LOCAL_VARIABLE)
@interface E{

}
/**
 * 修饰方法
 */
@Target(ElementType.METHOD)
@interface F{

}
/**
 * 修饰参数列表
 */
@Target(ElementType.PARAMETER)
@interface G{

}
/**
 * 修饰包
 * 注意点： 修饰包的文件里，不能声明 public class 或 public interface 。
 */
@Target(ElementType.PACKAGE)
@interface H{

}
/**
 * 用于描述类、接口(包括注解类型) 或enum声明
 * 注意点： 修饰包的文件里，不能声明 public class 或 public interface 。
 */
@Target(ElementType.TYPE)
@interface J{

}
/**
 * 用于描述类、接口(包括注解类型) 或enum声明 和 方法
 * 注意点： 修饰包的文件里，不能声明 public class 或 public interface 。
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@interface K{

}

