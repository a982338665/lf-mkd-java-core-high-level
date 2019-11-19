package pers.li.genericity.genericmethod;
public class ArrayUtilTest {

	public static void main(String[] args) {
		String s1 = ArrayUtil.<String>getMiddle("abc", "def", "ghi");
		Integer i1 = ArrayUtil.getMiddle(1,2,3);
		
		//null is ok
		String s2 = ArrayUtil.<String>getMiddle("abc", "def", null);
		
		//error 会先找里面3种元素共同的父类，然后转型再计算
//		Integer i2 = ArrayUtil.getMiddle(1,2.5f,3L);

	}

}
