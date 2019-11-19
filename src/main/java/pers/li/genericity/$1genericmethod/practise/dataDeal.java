package pers.li.genericity.$1genericmethod.practise;


public class dataDeal {

    public static <T extends String> T concat(T... ts) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String s:ts
             ) {
            stringBuffer.append(s);
        }
        return (T) stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.err.println(dataDeal.concat("1","2"," ","3"));
    }
}
