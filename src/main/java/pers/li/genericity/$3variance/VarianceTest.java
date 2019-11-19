package pers.li.genericity.$3variance;

import java.util.ArrayList;

public class VarianceTest {

	/**
	 * java数组是协变的
	 * {@link A}
	 * @see B
	 */
	public static void testArray() {
		B[] array1 = new B[1];
		array1[0] = new B();

		//父类接子类对象
		A[] array2 = array1;

		try {
			//子类对象原本只能放B，放A进入编译无错，运行报错
			array2[0] = new A();
			// compile ok, runtime error
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			//由于C类型是B的子类，所以可正常运行
			array2[0] = new C();
			// compile ok, runtime ok
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	/**
	 * java原始的泛型是不变的，即不使用通配符
	 * 泛型采用通配符，支持协变和逆变
	 */
	public static void testList() {
		ArrayList<B> list1 = new ArrayList<B>();
		list1.add(new B());

		//java原始的泛型是不变的，即不使用通配符
//		ArrayList<A> list2 = list1;
		//compile error
		
		ArrayList<? extends A> list3 = new ArrayList<B>();    //协变 B继承于A  B转A
		ArrayList<? super B> list4 = new ArrayList<A>();      //逆变 B继承于A  A转B

		
	}


	public static void testArrayAndList()
	{
//		B[] r1 = test(new ArrayList<B>()); //compile error
//		A[] r2 = test(new ArrayList<B>()); //compile error
//		Object[] r3 = test(new ArrayList<Object>()); //compile error
		
		A[] r4 = test(new ArrayList<A>());
		Object[] r5 = test(new ArrayList<A>());
	}
	
	public static A[] test(ArrayList<A> list)
	{
		return new A[1];
	}



}

class A {
} // 第一代

class B extends A {
} // 第二代

class C extends B {
} // 第三代

