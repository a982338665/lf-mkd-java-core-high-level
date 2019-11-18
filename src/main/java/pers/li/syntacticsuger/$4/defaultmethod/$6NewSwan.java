package pers.li.syntacticsuger.$4.defaultmethod;

public class $6NewSwan extends $3NewFlyAnimal implements $4NewLandAnimal{

	public static void main(String[] args) {
		new $6NewSwan().move();
		//当父类和父接口都有同名的方法，以父类的为主
		//这样可以兼容JDK7及以前的代码

	}

}
