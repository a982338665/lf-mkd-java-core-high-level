package pers.li.jvm.$4;

/**
 * 1.强引用：
 * 示例中设置最大堆内存为 5M： -Xmx5M
 */
public class StrongReferenceTest {

	public static void main(String[] args) {
		StringBuilder s1 = new StringBuilder();
		for(int i=0;i<10000;i++)
		{
			s1.append("00000000000000000000");
		}
		
		StringBuilder s2 = s1;
		s1 = null; //s1 为null, 但是s2依旧占据内存
		//s2 = null;
		//垃圾回收, 无法对强类型引用回收, 内存被占用, 引发异常
		System.gc();
		//最后再申请3M内存，加上字符串所占内存 > 5M,所以必然会报内存不足
		byte[] b = new byte[1024*1024*3];
		
	}

}
