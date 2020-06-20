package pers.li.streams.$5;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * reduce 传递一个二元函数进行计算
 */
public class Reduce {

	public static void main(String[] args) {
		
		Integer[] a = new Integer[] {2,4,6,8};
		//求和
		Stream<Integer> s1 = Stream.of(a);
		Optional<Integer> sum = s1.reduce(Integer::sum);
		System.out.println(sum.get());
		//求积
		Stream<Integer> s2 = Stream.of(a);
		Optional<Integer> product = s2.reduce((x,y)->x*y);
		System.out.println(product.get());
		//求积，1为初始值，最开始的乘数
		Stream<Integer> s3 = Stream.of(a);
		Integer product3 = s3.reduce(1,(x,y)->x*y);
		System.out.println(product3);
		//字符串连接
		String[] b = new String[] {"abc","def","ghi"};
		Stream<String> s4 = Stream.of(b);
		String bigStr = s4.reduce("00",(x,y)->x+y);
		System.out.println(bigStr);
		

	}

}
