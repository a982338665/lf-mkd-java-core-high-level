package pers.li.genericity.$2limits;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

	public static void main(String[] args) {
		
//		Pair<Apple> apples = new Pair<>(new Apple(3), new Apple(4));
//		Pair<Fruit> fruits = apples;
//		fruits.setFirst(new Orange(5));
//		
//		List<Orange> oranges = new ArrayList<Orange>();
		
		
//		Manager ceo = new Manager("ceo");
//		Manager cfo = new Manager("cfo");
//		
//		Pair<Manager> managers = new Pair<>(ceo, cfo);
//		Pair<Employee> employees = managers;
//		employees.setFirst(new Employee("zhangsan"));
		

		setFruits();
	}
	
	//Pair<Apple>  and Pair<Orange> 皆可 
	//Fruit的子类，都有getSize()方法
	//不能set，因为子类肯定能转为父类，但是set的时候不知道到底是哪个子类
	public void printFruits(Pair<? extends Fruit> fruits)
	{		
		Fruit first=fruits.getFirst();
		Fruit second=fruits.getSecond();
		
		System.out.println("The sizes of fruits are " 
		  + first.getSize() + "," + second.getSize());
	}
	
	public static void errorSetFruit()
	{
		Pair<Apple> apples = new Pair<>(new Apple(3), new Apple(4));
		apples.setFirst(new Apple(3));
		Pair<? extends Fruit> fruits = apples;
		apples.setFirst(new Apple(3));
		//fruits 里面保存的是Fruit的子类，但是不知道具体是哪个子类，所以不能保存
//		fruits.setFirst(new Orange(5)); //编译错误
	}
	
	public static void setFruits()
	{
		Pair<? super Apple> fruits = new Pair<Fruit>();
		
		fruits.setFirst(new Apple(5)); //Apple到超类的转型
		fruits.setSecond(new GreenApple(5)); //GreenApple到超类的转型
		
		//Fruit obj = fruits.getFirst(); //也未知其超类对象的方法，故报错			
		//fruits.getFirst()).hello(); //也未知其超类对象的方法，故报错		
	}

}
