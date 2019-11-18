package pers.li.syntacticsuger.$4.defaultmethod;

public interface $2NewAnimal {
    public default void move() {
        System.out.println("I can move.");
    }

    //不能重写Object的方法
//	public default String toString()
//	{
//		return "aaa";
//	}
}


