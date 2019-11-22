package pers.li.nestedclass.$3.commoninner;

public class Outer3 {
	String name = "aaaaaa";
	
	public class Bird extends Animal implements Flyable {
		public static final int a=3; //常量OK
		//public static int b = 4;   //error
		public void fly() {
			System.out.println("I can fly " + name);
		}

		public void eat() {
			System.out.println("I can fly");
		}
	}
	public Bird obj = new Bird();
	public void f1() {
		obj.fly();
		System.out.println(obj.getClass().getName());
		this.name = "bbbbbb";
		obj.fly();
	}
	
	public Bird getBird()
	{
		return this.obj;
	}

	public static void main(String[] args) {
		Outer3 foo1 = new Outer3();
		foo1.f1();

		Outer3.Bird foo2 = foo1.new Bird();
		foo2.fly();
		System.out.println(foo2 == foo1.getBird());

		//foo1对象下，有2个内部类对象和它关联

		//不允许没有关联的单独的普通内部类对象
//		Outer3.Bird foo3 = foo1.new Outer3.Bird();
	}

}

abstract class Animal {
	public abstract void eat();
}
interface Flyable {
	public void fly();
}
