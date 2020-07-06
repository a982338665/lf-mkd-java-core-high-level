package pers.li.jvm.$3;

/**
 * jvm栈存储的是方法里的信息，
 * 如果方法里的局部变量非常多的话
 * 在固定jvm栈大小的情况下，调用层数会急剧减少
 * 和 JvmStackSOF相比
 * 设置Vm参数：
 * 	-Xss100k的情况下，由于局部变量的增多，调用层数由
 * 	961 减为 343
 *	所以方法内的局部变量也会占用java栈内存
 */
public class JvmStackSOF2 {
	
	private int len = 1;
	public void f2() {
		//一个long变量 8字节，10个占用80字节，和出大小80B，
		//当在做方法嵌套的时候，每层嵌套都会多出这80b大小，所以层数会减少，所以如果程序里面变量特别多，嵌套很多的时候
		//就需要扩大jvm栈，由于jvm栈是线程私有的，如果线程很多，那么整个jvm也会报内存不足，查看 JvmStackOOM
		long a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;
		a1=a2=a3=a4=a5=a6=a7=a8=a9=a10=0;
		len ++;
		System.out.println(len);
		f2(); 
	}

	public static void main(String[] args) {
		new JvmStackSOF2().f2();
	}
}
