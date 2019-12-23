package pers.li.streams.$2;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicTypeStream {

    public static void main(String[] args) {

        IntStream s1 = IntStream.of(1, 2, 3, 4, 5);

        s1 = Arrays.stream(new int[]{1, 2, 3});
        s1 = IntStream.generate(() -> (int) (Math.random() * 100));
        s1 = IntStream.range(1, 5); //1,2,3,4  step 1
        s1 = IntStream.rangeClosed(1, 5); //1,2,3,4,5

        IntStream s2 = IntStream.of(1, 2, 3, 4, 5);
        //对象流和基本类型流相互转换
        Stream<Integer> s3 = s2.boxed();
        IntStream s5 = s3.mapToInt(Integer::intValue);


        //并行流
		IntStream range = IntStream.range(1, 1000000);
		long count = range.parallel().filter(n -> n % 2 == 0).count();
		System.err.println(count);
	}

}
