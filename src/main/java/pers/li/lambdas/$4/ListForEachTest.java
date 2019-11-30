package pers.li.lambdas.$4;

import java.util.Arrays;
import java.util.List;

public class ListForEachTest {

	public static void main(String[] args) {
		String[] planets = new String[] { 
				"Mercury", "Venus", "Earth", "Mars", 
				"Jupiter", "Saturn", "Uranus",
				"Neptune" };
		
		List<String> pList = Arrays.asList(planets);
		
		//��JDK5��ʼ֧��for-each�﷨�����������Ա�׾
		for(String s : pList)
		{
			System.out.println(s);
		}
		
		//��JDK8��ʼ֧��Lamdba���ʽ�����������
		pList.forEach(System.out::println);

	}

}
