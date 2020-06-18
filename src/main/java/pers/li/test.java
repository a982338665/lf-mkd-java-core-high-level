package pers.li;

public class test {

    public static void changeValue(StringBuffer param) {
        System.err.println("org:"+param);
        StringBuffer sb = new StringBuffer("Hi ");
        System.err.println("new:"+sb);
        param = sb;
        System.err.println("param:"+param);
        param.append("World!");
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


    public static void main(String[] args) {
        StringBuffer value = new StringBuffer("Hello ");
        changeValue(value);
        System.out.println("main方法的值："+value);
        changeValue2(value);
        System.out.println("main方法的值："+value);
    }
}
