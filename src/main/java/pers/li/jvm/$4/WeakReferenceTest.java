package pers.li.jvm.$4;

import java.lang.ref.WeakReference;

/**
 * 3.弱引用：
 * 只要gc 就回收
 */
public class WeakReferenceTest {

	public static void main(String[] args) {
		StringBuilder s1 = new StringBuilder();
		for(int i=0;i<100000;i++)
		{
			s1.append("0000000000");
		}
		
		WeakReference<StringBuilder> s2 = new WeakReference<StringBuilder>(s1);
		s1 = null;
		
		System.out.println(s2.get().length());
		
		System.gc();
		//弱引用，只要gc，就会回收
		System.out.println(s2.get()); //null
		
		byte[] b = new byte[(int)(1024*1024*3.5)];	
		
	}

}
