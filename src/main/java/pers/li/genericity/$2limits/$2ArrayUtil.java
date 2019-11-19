package pers.li.genericity.$2limits;

import java.io.Serializable;

public class $2ArrayUtil {
	public static <T extends Comparable & Serializable> T getMin(T... a) {
		if (null == a || a.length <= 0) {
			return null;
		}
		T min = a[0];

		for (int i = 1; i < a.length; i++) {
			if (min.compareTo(a[i]) > 0) {
				min = a[i];
			}
		}
		return min;
	}
}


