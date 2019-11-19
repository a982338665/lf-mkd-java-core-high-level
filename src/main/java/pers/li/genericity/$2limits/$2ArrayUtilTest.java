package pers.li.genericity.$2limits;

public class $2ArrayUtilTest {

	public static void main(String[] args) {
		$2ArrayUtil obj = new $2ArrayUtil();
		
		Integer result1 = obj.<Integer>getMin(1,2,3);
		Integer result2 = obj.getMin(3,2,1);
		
		System.out.println(result1);
		System.out.println(result2);
		
		//Person没有实现Comparable接口,所以报错
//		$2Person result3 = obj.<$2Person>getMin(new $2Person("Mike"), new $2Person("Tom"));
	}

}
