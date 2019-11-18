package pers.li.syntacticsuger.$4.defaultmethod;

public class $7Lion implements $1Animal, $2NewAnimal {

	public static void main(String[] args) {
		new $7Lion().move();

	}

	//当实现的2个接口都含有同名方法，且至少有一个是默认方法
	//则子类需要重写该方法，以免歧义
	public void move() {
		$2NewAnimal.super.move();
	}	

}
