package pers.li.reflection.$1.createobj;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ObjectCreate {

	public static void main(String[] args) throws Exception{
		//第一种 直接new 调用构造函数
		A obj1 = new A();
		obj1.hello();		
		
		
		//第二种 clone  
		//obj3 是obj2的克隆对象  没有调用构造函数
		B obj2 = new B();
		obj2.hello();		
		
		B obj3 = (B) obj2.clone();
		obj3.hello();
		
		//第三种 序列化  没有调用构造函数
		//序列化会引发安全漏洞，未来将被移除出JDK，请谨慎使用！！！
		C obj4  = new C();
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));   
	    out.writeObject(obj4);   
	    out.close();   
	       
	    ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));   
	    C obj5 = (C) in.readObject();   
	    in.close();   
	    obj5.hello(); 
		
		
		//第四种  newInstance  调用构造函数	    
		Object obj6 = Class.forName("pers.li.reflection.$1.createobj.A").newInstance();
		Method m = Class.forName("pers.li.reflection.$1.createobj.A").getMethod("hello");
		m.invoke(obj6);
		
		A obj7 = (A) Class.forName("pers.li.reflection.$1.createobj.A").newInstance();
		
		//第五种  newInstance  调用构造函数
		Constructor<A> constructor = A.class.getConstructor();   
		A obj8 = constructor.newInstance();
		obj8.hello();	
		
	}
}
