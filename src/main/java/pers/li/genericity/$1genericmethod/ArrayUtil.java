package pers.li.genericity.$1genericmethod;

public class ArrayUtil {
	public static <T> T getMiddle(T... a)
	{
		return a[a.length/2];
	}
}

