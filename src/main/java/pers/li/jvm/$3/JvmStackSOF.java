package pers.li.jvm.$3;

/**
 * 线程私有：
 * 存储类中每个方法的内容
 * -Xss最大栈值
 * -Xss1M
 * 递归报错：
 * 方法的递归调用，中间每一层方法的信息都需要存储在一个地方，方法嵌套越多，所占空间就越多，而这部分空间的大小就是通过 -Xss来设定的
 * 在运行前，VM arguments中添加参数：
 * 		-Xss1M
 * 			10540 StackOverFlowError
 * 		-Xss100k
 * 			961   StackOverFlowError
 *
 */
public class JvmStackSOF {
	
	private int len = 1;
	public void f1()
	{
		len ++;
		System.out.println(len);
		f1(); 
	}

	public static void main(String[] args) {
		new JvmStackSOF().f1();
	}
}
