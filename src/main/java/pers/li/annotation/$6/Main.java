package pers.li.annotation.$6;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;


@Fruit(name = "Apple")
public class Main {
    public static void main(String[] args) throws Exception{
//    	System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        Fruit fruit = Main.class.getAnnotation(Fruit.class);
        System.out.println(fruit.name());//Apple
        //输出fruit的真实类
        System.out.println(fruit.getClass().getName());
        //com.sun.proxy.$Proxy1
        //输出Fruit真实类的父接口
        System.out.println(fruit.getClass().getGenericInterfaces()[0]);
        //interface Fruit
//    	//生成代理类文件
    	InvocationHandler h = Proxy.getInvocationHandler(fruit);
        System.out.println(h.getClass().getName());
        //sun.reflect.annotation.AnnotationInvocationHandler 主要处理注解 位于rt.jar包中
        Field f = h.getClass().getDeclaredField("memberValues");
        f.setAccessible(true);
        Map memberValues = (Map) f.get(h);
        //only contain "name" key
        for(Object o : memberValues.keySet())
        {
        	System.out.println(o.toString());
        }
        //change the value of "name" key
        memberValues.put("name", "Pear");
        System.out.println(fruit.name()); //Pear
    }
}

