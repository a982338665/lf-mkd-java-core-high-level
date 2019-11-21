package pers.li.reflection.practise;

import java.io.Serializable;
import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.System.out;

/**
 * 反射详解：
 */
public class PractiseTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        System.err.println("创建Class的三种方式————————————————————————————————————————————");
        Class<A> aClass1 = A.class;
        Class<? extends A> aClass2 = new A("li").getClass();
        //使用此方式，抛出异常 ClassNotFoundException
        Class<?> aClass3 = Class.forName("pers.li.reflection.practise.A");
        System.err.println(aClass1.getName() + "\n" + aClass2.getName() + "\n" + aClass3.getName());
        System.err.println("不包含包名的名称：" + aClass1.getSimpleName());
        System.err.println("根据该Class创建该类的实例对象+++++++++++++++++++++++++++++++++++");
        //使用此方法必须要求类A有无参构造函数，未来会被移除，抛出异常IllegalAccessException, InstantiationException
        A a = aClass2.newInstance();
        //根据Class创建有参构造的实例对象
        //抛出异常NoSuchMethodException
        Constructor<? extends A> constructor = aClass2.getConstructor(String.class, int.class);
        //抛出异常 InvocationTargetException  String.class,int.class应该和"li",1数据类型一致，否则运行报错  wrong number of arguments
        A a1 = constructor.newInstance("li", 1);
        a.print();
        a1.print("22");
        //获取所有的构造函数
        Constructor<?>[] constructors = aClass1.getConstructors();
        System.err.println("反射获取对象属性及属性值Field+++++++++++++++++++++++++++++++++++++");
        //创建对象
        A li = new A("li", 23);
        //获取class
        Class<? extends A> aClass = li.getClass();
        //获取本类及父类所有的public字段
        Field[] fields = aClass.getFields();
        for (Field f : fields
        ) {
            System.err.println("public field:" + f.getName());
        }
        //获取本类所有声明的字段
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field f : declaredFields
        ) {
            //可以使得private临时变成public，变成可访问的
            f.setAccessible(true);
            //属性名 f.getName()
            //类型   f.getType()
            //属性值 f.get(li)
            System.err.println("child field:" + f.getName() + "|" + f.getType() + "|" + f.get(li));
        }
        System.err.println("反射获取方法Method+++++++++++++++++++++++++++++++++++++++");
        // 获取public方法 包括父类和父接口
        Method[] ms = aClass.getMethods();
        for (Method m : ms) {
//            System.err.println(m.getName());
            //此处，此种方式调用方法，方法不能被重载，否则无法识别方法中有几个参数
            if (m.getName().equals("other")){
                m.invoke(li, null);
            }
        }
        // 获得该类的所有方法
        Method[] ms2 = aClass.getDeclaredMethods();
        for (Method m : ms2) {
            if ("other1".equals(m.getName())) {
                m.setAccessible(true);
                String result = (String) m.invoke(li, null);
                System.err.println(result);
            }
        }
        //调用指定方法
        //Method m = aClass.getMethod("print", new Class[]{int.class,int.class});
        Method m = aClass.getMethod("print", int.class, int.class);
        //方法的反射操作
        Object invoke = m.invoke(li, 10, 20);
        System.err.println(invoke);//没有返回值则打印null
        System.err.println("反射获取父类+++++++++++++++++++++++++++++++");
        Class father = aClass.getSuperclass();
        System.out.println(father.getName());
        System.err.println("反射获取接口+++++++++++++++++++++++++++++++");
        Class[] inters = aClass.getInterfaces();
        for(Class inter : inters)
        {
            System.out.println(inter.getName());
        }
        System.err.println("反射获取注解+++++++++++++++++++++++++++++++");
        System.err.println("判断该类上是否有注解Test1："+aClass.isAnnotationPresent(Test1.class));
        Test1 annotation = aClass.getAnnotation(Test1.class);
        System.err.println(annotation.age());
        System.err.println(annotation.name());
        Field age = aClass.getField("age");
        boolean annotationPresent = age.isAnnotationPresent(Test1.class);
        System.err.println("判断该属性上是否有注解Test1："+annotationPresent);
        System.err.println(age.getAnnotation(Test1.class).age());
        System.err.println("判断方法上是否有注解Test1："+m.isAnnotationPresent(Test1.class));

    }
}

/**
 * 测试类
 */

@Test1(name="li")
class A extends B implements Serializable {

    @Test1(age = 16)
    public int age;
    private String name;

    public A(String name) {
        System.err.println("有参构造1");
    }

    public A(String name, int age) {
        this.name = name;
        this.age = age;
        System.err.println("有参构造2");
    }

    public A() {
        System.err.println("无参构造");
    }


    @Test1(age = 18)
    public void print() {
        System.err.println("no param");
    }
    public void other() {
        System.err.println("other param");
    }
    public String  other1() {
        System.err.println("other1 param");
        return "XXX";
    }

    public void print(String name) {
        System.err.println("have param :" + name);
    }

    public void print(int x, int y) {
        System.err.println(x + y);
    }

    public void print(String x, String y) {
        System.err.println("String:" + x + y);
    }
}


class B {
    public String sex;
}

@Retention(RetentionPolicy.RUNTIME)
@interface Test1{
    String name() default "1";
    int age() default 0;
}
