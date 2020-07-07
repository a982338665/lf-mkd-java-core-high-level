package pers.li.jvm.$4;

import java.lang.ref.SoftReference;
/**
 * 2.软引用：
 * 示例中设置最大堆内存为 5M： -Xmx5M
 */
public class SoftReferenceTest {

	/**
	 * first:::1000000
	 * second:::1000000
	 * null
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilder s1 = new StringBuilder();
		for(int i=0;i<100000;i++)
		{
			s1.append("0000000000");
		}
		
		SoftReference<StringBuilder> s2 = new SoftReference<StringBuilder>(s1);
		s1 = null;
		
		System.out.println("first:::"+s2.get().length()); //not null
		
		System.gc();
		//软引用, 内存不紧张, 没有回收
		System.out.println("second:::"+s2.get().length()); //not null
		
		byte[] b = new byte[(int)(1024*1024*3.5)];
		
		System.gc();
		//内存紧张, 软引用被回收
		System.out.println(s2.get()); //null
		
	}

}
