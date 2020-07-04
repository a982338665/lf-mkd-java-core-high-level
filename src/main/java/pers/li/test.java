package pers.li;

/**
 * 不管是值传递还是引用传递，形参拿到的仅仅是实参的副本，而不是实参本身。
 * 对象地址值其实就是指 hashcode
 * 值传递：
 *  参数类型是int，long等基本数据类型（八大基本数据类型），参数传递的过程采用值拷贝的方式
 *  int x =5 ;
 *  fun(5)
 *  serr(x)
 * 引用传递：
 *  参数类型为引用类型，参数传递的过程采用拷贝引用的方式
 *      A地址0001  ->  对象 id=1,name=1
 *      fun(A)//传递参数时候，拷贝引用
 *      funA地址 0001 ->  对象 id=1,name=1
 *      所以在对象改变时，外部对象的内容也会改变
 *  例如：
 *  A a = new A();
 *  fun(a);
 *
 */
public class test {

    public static void changeValue(StringBuffer param) {
        //1.引用传递：param指针 指向 "hello"
        System.err.println("value的内部引用:"+System.identityHashCode(param));
        System.err.println("org:"+param);
        StringBuffer sb = new StringBuffer("Hi ");
        System.err.println("sb的内部引用:"+System.identityHashCode(sb));
        System.err.println("new:"+sb);
        //2.param 指针 指向sb指向的地址 "Hi "
        param = sb;
        System.err.println("param的内部引用--:"+System.identityHashCode(param));
        System.err.println("sb的内部引用--:"+System.identityHashCode(sb));

        System.err.println("param:"+param);
        //3.param 指针 对应的内容为 Hi World!
        param.append("World!");
        System.err.println("param的内部引用--2:"+System.identityHashCode(param));
        System.err.println("sb的内部引用--2:"+System.identityHashCode(sb));
        System.out.println("方法内的值："+param);
    }
    public static void changeValue2(StringBuffer param) {
        System.err.println("org:"+param);
        StringBuffer sb = new StringBuffer("Hi ");
        System.err.println("new:"+sb);
        sb = param  ;
        System.err.println("param:"+sb);
        sb.append("World!");
        System.out.println("方法内的值："+sb);
    }

    /**
     * org:Hello
     * new:Hi
     * param:Hi
     * 方法内的值：Hi World!
     * main方法的值：Hello
     * org:Hello
     * new:Hi
     * param:Hello
     * 方法内的值：Hello World!
     * main方法的值：Hello World!
     * @param args
     */
    public static void main(String[] args) {
//        test test = new test();
//        System.err.println(test);
//        System.err.println(test.toString());
        StringBuffer value = new StringBuffer("Hello ");
        System.err.println("value的外部引用:"+System.identityHashCode(value));
        changeValue(value);
        System.err.println("value的外部引用===============:"+System.identityHashCode(value));
        System.out.println("main方法的值："+value);
        changeValue2(value);
        System.out.println("main方法的值："+value);

        test test = new test();
        System.err.println(test.hashCode());
        test = new test();
        System.err.println(test.hashCode());

    }
}
