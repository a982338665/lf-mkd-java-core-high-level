package pers.li.classloader.$4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CryptoClassLoader extends ClassLoader
{
   private int key = 3; 
   
   public Class<?> findClass(String name) throws ClassNotFoundException
   {
      try
      {
         System.err.println("findClass.......");
    	 byte[] classBytes = null;
         //读取Hello.caesar文件，得到所有字节流
         classBytes = loadClassBytes(name);
         //调用defineClass方法产生一个类，并在VM中注册
         Class<?> cl = defineClass(name, classBytes, 0, classBytes.length);
         if (cl == null) throw new ClassNotFoundException(name);
         return cl;
      }
      catch (IOException e)
      {
         throw new ClassNotFoundException(name);
      }
   }

   /**
    * Loads and decrypt the class file bytes.
    * @param name the class name
    * @return an array with the class file bytes
    */
   private byte[] loadClassBytes(String name) throws IOException
   {
      System.err.println("loadClassBytes................");
      String cname = "D:\\go-20191030\\CoreHighLevel\\src\\main\\java\\pers\\li\\classloader\\$4\\Hello.caesar";
      byte[] bytes = Files.readAllBytes(Paths.get(cname));
      for (int i = 0; i < bytes.length; i++)
         bytes[i] = (byte) (bytes[i] - key);
      return bytes;
   }
}
