package pers.li.annotation.$4;

import java.lang.annotation.Inherited;

/**
 * 注解继承：由于@Test1注解上有关键字@Inherited
 * 父类有此注解，那么子类也将继承该注解，若没有则该注解仅存在父类上
 */
public class InheritedTest extends superClass{


}

@Test1
class superClass{

}

@Inherited
@interface Test1{

}
