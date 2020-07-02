package pers.li.classloader.$4;

import java.lang.reflect.*;

/**
 * 测试之前要删除生成的 Hello.class文件
 * 当加载的时候找不到该文件时，则会默认调用自定义类加载器的findClass方法:
 *
 * Connected to the target VM, address: '127.0.0.1:55904', transport: 'socket'
 * findClass.......
 * loadClassBytes................
 * hello
 * pers.li.classloader.$4.CryptoClassLoader
 */
public class ClassLoaderTest
{
   public static void main(String[] args)
   {
	   try
	      {
	         ClassLoader loader = new CryptoClassLoader();
	         //loadClass去加载Hello类
	         //loadClass是ClassLoader默认方法，通过委托双亲去加载类
	         //如加载不到，则调用findClass方法加载
	         Class<?> c = loader.loadClass("pers.li.classloader.$4.Hello");
	         Method m = c.getMethod("say");
	         m.invoke(c.newInstance());
	         
	         System.out.println(c.getClassLoader().getClass().getName());
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
   }
}


