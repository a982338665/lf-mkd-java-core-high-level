package pers.li.classloader.$2;

public class Worker {
	public void say()
	{
		System.out.println("I am loaded by AppClassLoader");
		ClassLoader c = Worker.class.getClassLoader();
		if(null != c)
		{
			System.out.println(c.getClass().getName());
		}
		else
		{
			System.out.println("Bootstrap Classloader");
		}
	}
}
