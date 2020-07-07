package pers.li.jvm.$4;

/**
 *
 * f1方法中，有局部变量
 * s1（栈内存） 指向  “123”（堆内存） String类及方法信息（方法区）
 * 当方法f1结束后，s1 指向 123 断开
 * 当 s1 赋值给 s2 后
 * s2（栈内存） 指向  “123”（堆内存）
 *
 * */
public class Test {

	public static void main(String[] args) {
		Test foo = new Test();
		//对象的引用
		String s2 = foo.f1();
	}
	
	public String f1()
	{
		String s1 = new String("123");
		return s1;
	}

}
