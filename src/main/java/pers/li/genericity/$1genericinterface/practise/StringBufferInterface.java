package pers.li.genericity.$1genericinterface.practise;

public interface StringBufferInterface<T extends String> {
    public T concat (T... t2);
}


class TestStringBuffer implements StringBufferInterface<String>{
    @Override
    public String concat(String... t2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String s:t2
             ) {
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        TestStringBuffer test = new TestStringBuffer();
        String add = test.concat("1","2");
        StringBufferInterface<String> test2 =  new TestStringBuffer();
        String add2 = test2.concat("1","2");
        System.err.println(add+"|"+add2);
    }
}
