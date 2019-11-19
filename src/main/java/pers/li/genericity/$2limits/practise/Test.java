package pers.li.genericity.$2limits.practise;

public class Test {

    public static void main(String[] args) {
        Fan<?> fan = new Fan(new A1(),new A2());
        Object fan1 = fan.getFan1();
        A1 a = (A1)fan1;
        a.thisName();
//        fan.setFan1(new A1());
        System.err.println("? super A1只能存放A1及其子类对象并且不能get，因为不知道放进去的对象是哪个+++++++++++++++++++++++++++++===");
        Fan<? super A1> fan2 = new Fan<A>();
        fan2.setFan1(new A1());
        fan2.setFan2(new A11());
        Object fan11 = fan2.getFan1();
        A1 ss = (A1)fan11;
        ss.thisName();
//        A fan11 = fan2.getFan1();
        System.err.println("? extends A只能取值不能放值,因为T必须是继承于A的子类，放值时无法知道到底是哪个子类+++++++++++++++++++++++++++++===");
        Fan<? extends A> fan3 = new Fan(new A1(),new A2());
        fan3.getFan1().thisName();
        fan3.getFan2().thisName();
       /* fan3.setFan2(new A1());
        fan3.setFan2(new A2());
        fan3.setFan2(new A() {
            @Override
            public void thisName() {

            }
        });*/
        System.err.println("真实泛型========================================");
        Fan<A> fan4 = new Fan(new A1(),new A2());
        fan4.getFan1().thisName();
        fan4.getFan2().thisName();
        fan4.setFan2(new A2());
    }


}

//定义父类
abstract class A {
    private int s;

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public abstract void thisName();
}

//定义子类
class A1 extends A {

    @Override
    public void thisName() {
        System.err.println("this is A1");
    }
}
//定义子类
class A11 extends A1 {
    @Override
    public void thisName() {
        System.err.println("this is A11");
    }
}
//定义子类
class A2 extends A {
    @Override
    public void thisName() {
        System.err.println("this is A2");
    }
}

//定义泛型类
class Fan<T>{
    private T fan1;
    private T fan2;

    public T getFan1() {
        return fan1;
    }

    public void setFan1(T fan1) {
        this.fan1 = fan1;
    }

    public T getFan2() {
        return fan2;
    }

    public void setFan2(T fan2) {
        this.fan2 = fan2;
    }

    public Fan(T fan1, T fan2) {
        this.fan1 = fan1;
        this.fan2 = fan2;
    }
    public Fan() {
        this.fan1 = null;
        this.fan2 = null;
    }
}
