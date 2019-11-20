package pers.li.reflection.$1.createobj;

public class B implements Cloneable {
	public void hello()
	{
		System.out.println("hello from B");
	}
	
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}
