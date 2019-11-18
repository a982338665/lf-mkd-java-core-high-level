package pers.li.syntacticsuger.$4.defaultmethod;

/**
 * 新接口可继承，可实现
 */
public interface $4NewLandAnimal extends  $2NewAnimal {
	public default void move()
	{
		System.out.println("I can move on land.");
	}
}
