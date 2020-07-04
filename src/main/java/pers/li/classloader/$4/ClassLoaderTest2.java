package pers.li.classloader.$4;
import pers.li.classloader.$4.Hello;

/**
 * java.lang.ClassCastException: class pers.li.classloader.$4.Hello cannot be cast to class pers.li.classloader.$4.Hello
 * (pers.li.classloader.$4.Hello is in unnamed module of loader pers.li.classloader.$4.CryptoClassLoader @39fb3ab6; pers.li.classloader.$4.Hello is in unnamed module of loader 'app')
 */
public class ClassLoaderTest2
{
   public static void main(String[] args)
   {
	   try
	      {
		   Hello obj1 = new Hello(); //sun.misc.Launcher$AppClassLoader
		   
		   CryptoClassLoader loader = new CryptoClassLoader();		   
		   Object obj2 = loader.findClass("pers.li.classloader.$4.Hello").newInstance();
		   //obj2 CryptoClassLoader

			  //编译通过，运行报错
//		   Hello obj3 = (Hello) obj2;//compile ok
		   
		   System.out.println(obj1.getClass().getClassLoader().getClass().getName());
		   System.out.println(obj2.getClass().getClassLoader().getClass().getName());
		  
		
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
   }
}


